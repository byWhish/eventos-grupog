package unq.tpi.desapp.model;

import org.junit.Ignore;
import org.junit.Test;
import unq.tpi.desapp.builders.EventBuilder;
import unq.tpi.desapp.builders.GuestBuilder;
import unq.tpi.desapp.builders.ProductBuilder;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


@Ignore
public class MoneyCollectionEventTest {

    @Test
    public void theAmountToPayIsAlwaysZero() {
        Guest guest = new GuestBuilder().getGuest();
        Guest guest2 = new GuestBuilder().getGuest();
        Product product = new ProductBuilder().withAmountLimit(3).getProduct();
        Event event = new EventBuilder("moneyCollection").withGuests(Arrays.asList(guest, guest2)).getEvent();

        Double halfPrice = product.price / 2;
        assertEquals(event.amountToPay(guest), halfPrice);
    }
}
