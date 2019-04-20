package unq.tpi.desapp.model;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import unq.tpi.desapp.builders.EventBuilder;
import unq.tpi.desapp.builders.GuestBuilder;
import unq.tpi.desapp.builders.ProductBuilder;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@Ignore
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
        Product product = new ProductBuilder().withAmountLimit(3).getProduct();
        Event event = new EventBuilder("commonAccount").withGuests(Arrays.asList(guest, guest2)).withProducts(Arrays.asList(product)).getEvent();

        Double halfPrice = product.price / 2;
        assertEquals(event.amountToPay(guest), halfPrice);
    }
}
