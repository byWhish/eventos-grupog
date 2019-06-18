package unq.tpi.desapp.model;

//import org.springframework.beans.factory.annotation.Autowired;
//import unq.tpi.desapp.service.FinancialService;

public class ExternalAccount extends Account{

    public String uri;

    //@Autowired
    //private FinancialService financialService;

    @Override
    public void credit(Movement movement) {
        //financialService.sendExternalPayment( movement, this.uri );
    }

    @Override
    public void debit(Movement movement) throws Exception {}
}
