package unq.tpi.desapp.model;

import org.junit.Before;
import org.junit.Test;
import unq.tpi.desapp.builders.CommonAccountEventBuilder;
import unq.tpi.desapp.builders.GuestBuilder;
import unq.tpi.desapp.builders.ProductBuilder;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class MoneyCollectionEventTest {

    @Before
    public void initialize() {
        Product mockedProduct = mock(Product.class);
        when(mockedProduct.getPrice()).thenReturn(10.0);
    }

    @Test
    public void theAmountToPayIsSamePropportionToAnyGuest() {
        Guest guest = new GuestBuilder().getGuest();
        Guest guest2 = new GuestBuilder().getGuest();
        Expense aExpense = new Expense(guest, 10.0);
        Product product = new ProductBuilder().withAmountLimit(3).getProduct();
        CommonAccountEvent event = new CommonAccountEventBuilder().withGuests(Arrays.asList(guest, guest2))
                .withProducts(Collections.singletonList(product)).build();
        event.informExpenses(aExpense);
        Double halfPrice = event.getExpenses() / 2;;
        assertEquals(event.amountToPay(guest), halfPrice);
        assertEquals(event.getGuestExpeses(aExpense.getGuest()), aExpense.getAmount());
    }
}
