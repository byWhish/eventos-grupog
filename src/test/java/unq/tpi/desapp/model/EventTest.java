package unq.tpi.desapp.model;

import org.junit.Ignore;
import org.junit.Test;
import unq.tpi.desapp.builders.EventBuilder;
import unq.tpi.desapp.builders.GuestBuilder;
import unq.tpi.desapp.builders.ProductBuilder;
import unq.tpi.desapp.builders.UserBuilder;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class EventTest {

    @Test
    public void whenTheEventHasNoCollaboratorsItShouldHaveTheBasicPriceOfItsProducts() {
        Product product = new ProductBuilder().withAmountLimit(3).getProduct();
        Event event = new EventBuilder("party")
                .withProducts(Arrays.asList(product))
                .withGuests(new ArrayList<>())
                .getEvent();

        assertEquals(event.totalAmount(), product.price);
    }

    @Test
    public void whenTheEventHasLessCollaboratorsThanAmountLimitItShouldHaveTheBasicPriceOfItsProducts() {
        Product product = new ProductBuilder().withAmountLimit(3).getProduct();
        Guest guest1 = new GuestBuilder().getGuest();
        Guest guest2 = new GuestBuilder().getGuest();
        Event event = new EventBuilder("party")
                .withProducts(Arrays.asList(product))
                .withGuests(Arrays.asList(guest1, guest2))
                .getEvent();

        assertEquals(event.totalAmount(), product.price);
    }

    @Ignore
    @Test
    public void whenTheEventHasMoreCollaboratorsThanAmountLimitItShouldHaveTwiceTheBasicPriceOfItsProducts() {
        Product product = new ProductBuilder().withAmountLimit(1).getProduct();
        Guest guest1 = new GuestBuilder().getGuest();
        Guest guest2 = new GuestBuilder().getGuest();
        Event event = new EventBuilder("party")
                .withProducts(Arrays.asList(product))
                .withGuests(Arrays.asList(guest1, guest2))
                .getEvent();

        Double expectedAmount = product.price * 2;
        assertEquals(event.totalAmount(), expectedAmount);
    }

}
