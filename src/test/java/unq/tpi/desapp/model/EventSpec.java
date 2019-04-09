package unq.tpi.desapp.model;

import org.junit.Test;
import unq.tpi.desapp.builders.EventBuilder;
import unq.tpi.desapp.builders.ProductBuilder;
import unq.tpi.desapp.builders.UserBuilder;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class EventSpec {

    @Test
    public void whenTheEventHasNoCollaboratorsItShouldHaveTheBasicPriceOfItsProducts() {
        Product product = new ProductBuilder().withAmountLimit(3).getProduct();
        Event event = new EventBuilder("party")
                .withProducts(Arrays.asList(product))
                .withCollaborators(new ArrayList<>())
                .getEvent();

        assertEquals(event.totalAmount(), product.price);
    }

    @Test
    public void whenTheEventHasLessCollaboratorsThanAmountLimitItShouldHaveTheBasicPriceOfItsProducts() {
        Product product = new ProductBuilder().withAmountLimit(3).getProduct();
        User user1 = new UserBuilder().getUser();
        User user2 = new UserBuilder().getUser();
        Event event = new EventBuilder("party")
                .withProducts(Arrays.asList(product))
                .withCollaborators(Arrays.asList(user1, user2))
                .getEvent();

        assertEquals(event.totalAmount(), product.price);
    }

    @Test
    public void whenTheEventHasMoreCollaboratorsThanAmountLimitItShouldHaveTwiceTheBasicPriceOfItsProducts() {
        Product product = new ProductBuilder().withAmountLimit(1).getProduct();
        User user1 = new UserBuilder().getUser();
        User user2 = new UserBuilder().getUser();
        Event event = new EventBuilder("party")
                .withProducts(Arrays.asList(product))
                .withCollaborators(Arrays.asList(user1, user2))
                .getEvent();

        Double expectedAmount = product.price * 2;
        assertEquals(event.totalAmount(), expectedAmount);
    }

}
