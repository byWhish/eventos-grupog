package unq.tpi.desapp.model;

import org.junit.Test;
import unq.tpi.desapp.builders.*;
import unq.tpi.desapp.model.event.Event;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PartyTest {

    @Test
    public void whenTheEventHasNoCollaboratorsItShouldHaveTheBasicPriceOfItsProducts() {
        Product product = new ProductBuilder().withAmountLimit(3).getProduct();
        Event event = getPartyBuilder()
                .withProducts(Arrays.asList(product))
                .withGuests(new ArrayList<>())
                .getEvent();

        assertEquals(event.totalAmount(), product.price);
    }

    @Test
    public void whenTheEventHasLessCollaboratorsThanAmountLimitItShouldHaveTheBasicPriceOfItsProducts() {
        Product product = new ProductBuilder().withAmountLimit(3).getProduct();
        Guest guest1 = createGuestThatConfirmedAssistance();
        Guest guest2 = createGuestThatConfirmedAssistance();
        Event event = getPartyBuilder()
                .withProducts(Arrays.asList(product))
                .withGuests(Arrays.asList(guest1, guest2))
                .getEvent();

        assertEquals(event.totalAmount(), product.price);
    }

    @Test
    public void whenTheEventHasMoreCollaboratorsThanAmountLimitItShouldHaveTwiceTheBasicPriceOfItsProducts() {
        Product product = new ProductBuilder().withAmountLimit(1).getProduct();
        Guest guest1 = createGuestThatConfirmedAssistance();
        Guest guest2 = createGuestThatConfirmedAssistance();
        Event event = getPartyBuilder()
                .withProducts(Arrays.asList(product))
                .withGuests(Arrays.asList(guest1, guest2))
                .getEvent();

        Double expectedAmount = product.price * 2;
        assertEquals(event.totalAmount(), expectedAmount);
    }

    @Test
    public void whenTheOwnerHaveToPayWeGetTheAmount() {
        Product product = new ProductBuilder().getProduct();
        Guest guest = createGuestThatConfirmedAssistance();
        guest.setOwner(Boolean.TRUE);
        Event event = getPartyBuilder()
                .withProducts(Arrays.asList(product))
                .withGuests(Arrays.asList(guest))
                .getEvent();

        Double expectedAmount = product.price;
        assertEquals(event.amountToPay(guest), expectedAmount);
    }

    @Test
    public void whenAGuestHaveToPayHeDoesntHaveToPayAnything() {
        Guest guest = createGuestThatConfirmedAssistance();
        guest.setOwner(Boolean.FALSE);
        Event event = getPartyBuilder()
                .withGuests(Arrays.asList(guest))
                .getEvent();

        assertEquals(event.amountToPay(guest), (Double) 0.0);
    }

    private EventBuilder getPartyBuilder() {
        return new EventBuilder("party");
    }

    private Guest createGuestThatConfirmedAssistance() {
        new EventTemplateBuilder().build();
        new MovementBuilder().build();
        new ExpenseBuilder().build();
        return new GuestBuilder().withConfirmedAssistance(Boolean.TRUE).getGuest();
    }

}
