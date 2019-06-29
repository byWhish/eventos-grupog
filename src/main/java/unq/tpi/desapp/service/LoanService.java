package unq.tpi.desapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import unq.tpi.desapp.exception.InsufficientFundsException;
import unq.tpi.desapp.model.Loan;
import unq.tpi.desapp.model.Movement;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.persistence.LoanRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LoanService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoanService.class);

    @Autowired
    AccountsService userService;

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    private FinancialService financialService;

    @Scheduled(cron = "0 * * ? * *")
    public void payOngoingLoans() {
        LOGGER.info("Comienza el proceso de pago de cuotas");
        List<Loan> loans = loanRepository.findOngoingLoans();
        payLoans(loans);
    }

    private void payLoans(List<Loan> loans) {
        loans.stream().forEach(loan -> payLoan(loan, Boolean.FALSE));
    }

    private void payLoan(Loan loan, Boolean shouldFail) {
        try {
            loan.installmentsToPay().stream().forEach(installment -> {
                Movement movement = installment.pay();
                financialService.processMovement(movement);
            });
        } catch (InsufficientFundsException ex)
        {
            LOGGER.error("No se pudo hacer el pago del prestamo " + loan.getId());
            if (shouldFail) throw ex;
        }
        loanRepository.save(loan);
        userService.saveUser(loan.getUser());
    }

    @Transactional
    public void payUserDebt(Long loanId) {
        Loan loan = loanRepository.findById(loanId).get();
        payLoan(loan, Boolean.TRUE);
    }

    @Transactional
    public Loan applyLoan(Long userId) {
        User user = userService.findUserById(userId);
        Loan loan = new Loan(1000.0, 6, user);
        loanRepository.save(loan);
        userService.saveUser(user);
        return loan;
    }

    public List<Loan> listLoans(Long userId) {
        return loanRepository.findAllByUser(userId);
    }
}
