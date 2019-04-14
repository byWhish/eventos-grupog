package unq.tpi.desapp.model;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import unq.tpi.desapp.builders.AccountBuilder;
import unq.tpi.desapp.builders.TransferBuilder;

public class TransferTest {

    @Test
    public void whenCommitATransferWithSuficientFoundsThenDestinationAccountBalanceResultInBalancePlusAmount()
        throws Exception {
    Account origin = new AccountBuilder().withBalance(100.0).build();
    Account destination = new AccountBuilder().withBalance(100.0).build();
    Transfer transfer = new TransferBuilder().withOrigin(origin).withDestination(destination).withAmount(10.0).build();
    transfer.commit();
    assertEquals(origin.getBalance(), 90.0, 0);
    assertEquals(destination.getBalance(), 110.0, 0);
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void whenCommitATranferWhitInsuficientFoundsThenThrowsException() throws Exception {
        Account origin = new AccountBuilder().withBalance(100.0).build();
        Account destination = new AccountBuilder().withBalance(100.0).build();
        Transfer transfer = new TransferBuilder().withOrigin(origin).withDestination(destination).withAmount(110.0).build();
        exceptionRule.expectMessage("Insuficient founds");
        transfer.commit();
    }
};