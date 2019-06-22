package unq.tpi.desapp.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unq.tpi.desapp.model.Movement;
import unq.tpi.desapp.request.ExternalMovementRequest;
import unq.tpi.desapp.service.FinancialService;

@RestController
@RequestMapping("/movement")
public class FinancialWebService {

    @Autowired
    private FinancialService financialService;

    @PostMapping
    public void processMovement(@RequestBody Movement movement) {
        financialService.processMovement(movement);
    }

    @PostMapping("/external/credit")
    public void processExternalCredit(@RequestBody ExternalMovementRequest externalMovement) {
        financialService.processMovement(financialService.generateCreditMovement(externalMovement));
    }

    @PostMapping("/external/debit")
    public void processExternalDebit(@RequestBody ExternalMovementRequest externalMovement) {
        financialService.processMovement(financialService.generateDebitMovement(externalMovement));
    }

}
