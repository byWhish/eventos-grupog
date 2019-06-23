package unq.tpi.desapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unq.tpi.desapp.model.Account;
import unq.tpi.desapp.model.AccountMaster;
import unq.tpi.desapp.model.Movement;
import unq.tpi.desapp.persistence.AccountRepository;
import unq.tpi.desapp.persistence.GuestRepository;
import unq.tpi.desapp.persistence.MovementRepository;
import unq.tpi.desapp.request.ExternalMovementRequest;
import unq.tpi.desapp.request.MovementDTO;

import javax.transaction.Transactional;

@Service
public class FinancialService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    MovementRepository movementRepository;

    @Autowired
    GuestRepository guestRepository;

    @Transactional
    public Boolean processMovement(MovementDTO movementDTO) {
        Account origin = accountRepository.findById(movementDTO.getOriginId()).orElse(null);
        Account destination = accountRepository.findById(movementDTO.getDestinationId()).orElse(null);
        Movement movement = new Movement(origin, destination, movementDTO.amount, movementDTO.description);
        return processMovement(movement);
    }

    @Transactional
    public Boolean processMovement(Movement movement) {
        accountRepository.save(movement.getOrigin());
        accountRepository.save(movement.getDestination());
        movementRepository.save(movement);
        return true;
    }

    public MovementDTO generateDebitMovement(ExternalMovementRequest externalMovement) {
        return new MovementDTO(
                externalMovement.getAccountId(),
                (long) 1,
                externalMovement.getAmount(),
                externalMovement.getDescription()
        );
    };
    public MovementDTO generateCreditMovement(ExternalMovementRequest externalMovement) {
        return new MovementDTO(
                (long) 1,
                externalMovement.getAccountId(),
                externalMovement.getAmount(),
                externalMovement.getDescription()
        );
    }

    public void sendExternalPayment(Movement movement, String uri) {}

    public void createMasterAccount() {
        AccountMaster accountMaster = new AccountMaster();
        accountRepository.save(accountMaster);
    }

    public Account findAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }
}
