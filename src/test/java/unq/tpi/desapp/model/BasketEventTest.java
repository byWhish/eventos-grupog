package unq.tpi.desapp.model;

import org.junit.Test;
import unq.tpi.desapp.builders.EventBuilder;
import unq.tpi.desapp.builders.GuestBuilder;
import unq.tpi.desapp.builders.ProductBuilder;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BasketEventTest {

    @Test
    public void theAmountToPayIsAlwaysZero() {
        Guest guest = new GuestBuilder().getGuest();
        Event event = new EventBuilder("basket").withGuests(Arrays.asList(guest)).getEvent();

        assertEquals(event.amountToPay(guest), (Double) 0.0);
    }

    @Test
    public void getsTheCollaboratorsForAnSpecificProduct() {
        Product product = new ProductBuilder().getProduct();
        List<Product> productList = Arrays.asList(product);
        Guest guest = new GuestBuilder().withProducts(productList).getGuest();
        Event event = new EventBuilder("basket").withGuests(Arrays.asList(guest)).getEvent();

        assert(event.collaboratorsFor(product).contains(guest));
    }
}
