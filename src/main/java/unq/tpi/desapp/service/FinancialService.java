package unq.tpi.desapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unq.tpi.desapp.model.Account;
import unq.tpi.desapp.model.Movement;
import unq.tpi.desapp.persistence.AccountRepository;
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

    @Transactional
    public Boolean processMovement(MovementDTO movementDTO) {
        Account origin = accountRepository.findById(movementDTO.getOriginId()).orElse(null);
        Account destination = accountRepository.findById(movementDTO.getDestinationId()).orElse(null);
        Movement movement = new Movement(origin, destination, movementDTO.amount, movementDTO.description);
        processMovement(movement);
        return true;
    }

    @Transactional
    public Boolean processMovement(Movement movement) {
        movementRepository.save(movement);
        accountRepository.save(movement.getOrigin());
        accountRepository.save(movement.getDestination());
        return true;
    }


    public MovementDTO generateDebitMovement(ExternalMovementRequest externalMovement) {
        String description = String.format("Debit from %s id: %d}", externalMovement.companyName, externalMovement.operationId);
        return new MovementDTO(
                externalMovement.accountId,
                externalMovement.externalId,
                externalMovement.amount,
                description
        );
    };
    public MovementDTO generateCreditMovement(ExternalMovementRequest externalMovement) {
        String description = String.format("Credit from %s id: %d}", externalMovement.companyName, externalMovement.operationId );
        return new MovementDTO(
                externalMovement.externalId,
                externalMovement.accountId,
                externalMovement.amount,
                description
        );
    }

    public void sendExternalPayment(Movement movement, String uri) {}
}
