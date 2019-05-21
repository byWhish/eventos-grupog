package unq.tpi.desapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unq.tpi.desapp.model.Account;
import unq.tpi.desapp.model.Movement;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.persistence.AccountRepository;
import unq.tpi.desapp.request.ExternalMovementRequest;

import javax.transaction.Transactional;

@Service
public class FinancialService {

    @Autowired
    AccountRepository accountRepository;

    @Transactional
    public Boolean processMovement(Movement movement) throws Exception {
        Account origin = accountRepository.findById(movement.getOriginId()).orElse(null);
        Account destination = accountRepository.findById(movement.getDestinationId()).orElse(null);
        origin.debit(movement);
        destination.credit(movement);
        accountRepository.save(origin);
        accountRepository.save(destination);
        return true;
    }

    public Movement generateDebitMovement(ExternalMovementRequest externalMovement) {
        String description = String.format("Debit from %s id: %d}", externalMovement.companyName, externalMovement.operationId);
        return new Movement(
                externalMovement.accountId,
                externalMovement.externalId,
                externalMovement.amount,
                description
        );
    };
    public Movement generateCreditMovement(ExternalMovementRequest externalMovement) {
        String description = String.format("Credit from %s id: %d}", externalMovement.companyName, externalMovement.operationId );
        return new Movement(
                externalMovement.externalId,
                externalMovement.accountId,
                externalMovement.amount,
                description
        );
    }

    public void sendExternalPayment(Movement movement, String uri) {}
}
