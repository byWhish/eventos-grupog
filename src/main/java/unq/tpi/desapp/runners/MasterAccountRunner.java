package unq.tpi.desapp.runners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import unq.tpi.desapp.service.FinancialService;

@Component
@Order(1)
public class MasterAccountRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(MasterAccountRunner.class);

    @Autowired
    FinancialService financialService;

    @Override
    public void run(String... args) throws Exception {
           try {
               financialService.createMasterAccount();
               LOGGER.info("Master Account Saved!");

           } catch (Exception e){
               LOGGER.error("Unable to save Master Account");
           }
    }
}
