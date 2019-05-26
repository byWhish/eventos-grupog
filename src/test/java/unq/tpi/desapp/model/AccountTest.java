package unq.tpi.desapp.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import unq.tpi.desapp.builders.AccountBuilder;
import unq.tpi.desapp.builders.MovementBuilder;
import unq.tpi.desapp.builders.UserBuilder;

import static org.junit.Assert.assertEquals;

public class AccountTest {

    @Test
    public void creatingAnAccountWorksVeryWell() {
        String alias = null;
        Account anAccount = new Account();

        assertEquals(anAccount.getAlias(), alias);
    }

    @Test
    public void whenDebitAnAmountToAnAccountThenBalanceResultInBalanceLessAmount() throws Exception {
        Account anAccount = new AccountBuilder().withBalance(100.0).build();
        Movement movement = new MovementBuilder().withAmount(10.0).build();
        anAccount.debit(movement);
        assertEquals(anAccount.getBalance(), 90.0, 0);
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void whenDebitAnAmountToAnAccountWhitInsuficientFoundsThenThrowsException() throws Exception {
        Account anAccount = new AccountBuilder().withBalance(0.0).build();
        Movement movement = new MovementBuilder().withAmount(10.0).build();
        exceptionRule.expectMessage("Insuficient founds");
        anAccount.debit(movement);
    }

    @Test
    public void whenCreditAnAmountToAnAccountThenBalanceResultInBalancePlusAmount() {
        Account anAccount = new AccountBuilder().withBalance(100.0).build();
        Movement movement = new MovementBuilder().withAmount(10.0).build();
        anAccount.credit(movement);
        assertEquals(anAccount.getBalance(), 110.0, 0);
    }
}