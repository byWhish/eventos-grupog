package unq.tpi.desapp.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unq.tpi.desapp.model.Account;
import unq.tpi.desapp.model.Movement;
import unq.tpi.desapp.request.ExternalMovementRequest;
import unq.tpi.desapp.service.FinancialService;

@RestController
@RequestMapping("/api/private/movement")
public class FinancialWebService {

    @Autowired
    private FinancialService financialService;

    @PostMapping
    public void processMovement(@RequestBody Movement movement) {
        financialService.processMovement(movement);
    }

    @PostMapping("/external/credit")
    public boolean processExternalCredit(@RequestBody ExternalMovementRequest externalMovement) {
        return financialService.processMovement(financialService.generateCreditMovement(externalMovement));
    }

    @PostMapping("/external/debit")
    public boolean processExternalDebit(@RequestBody ExternalMovementRequest externalMovement) {
        return financialService.processMovement(financialService.generateDebitMovement(externalMovement));
    }

    @GetMapping("/account/{id}")
    public Account getAccount(@PathVariable Long id) {
        return financialService.findAccountById(id);
    }
}

