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
        List<Loan> loans = loanRepository.findOngoingLoans();
        loans.stream().forEach(loan -> {
                    try {
                        Movement movement = loan.nextInstallment().pay();
                        financialService.processMovement(movement);
                    } catch (InsufficientFundsException ex)
                    {
                        LOGGER.error("No se pudo hacer el pago del prestamo " + loan.getId());
                    }
                    loanRepository.save(loan);
                    userService.saveUser(loan.getUser());
                }
        );
    }

    @Transactional
    public Loan applyLoan(Long userId) {
        User user = userService.findUserById(userId);
        Loan loan = new Loan(1000.0, 6, user);
        loanRepository.save(loan);
        userService.saveUser(user);
        return loan;
    }
}
