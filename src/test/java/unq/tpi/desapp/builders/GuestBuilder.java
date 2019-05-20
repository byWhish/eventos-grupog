package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.event.Event;
import unq.tpi.desapp.model.Guest;
import unq.tpi.desapp.model.Product;
import unq.tpi.desapp.model.User;

import java.util.Arrays;
import java.util.List;

public class GuestBuilder {

    Guest guest;

    public GuestBuilder() {
        Event event =  new EventBuilder("party").getEvent();
        init(event);
    }

    public GuestBuilder(Event event) {
        init(event);
    }

    private void init(Event event) {
        Product product = new ProductBuilder().getProduct();
        User user = new UserBuilder().getUser();
        guest = new Guest(event, user);

        withConfirmedAssistance(Boolean.TRUE);
        withProducts(Arrays.asList(product));
        guest.setUser(user);
        guest.setEvent(event);
        guest.setId(1L);
    }

    public GuestBuilder withConfirmedAssistance(Boolean confirmedAssistance) {
        guest.setConfirmedAssistance(confirmedAssistance);
        guest.getConfirmedAssistance();
        return this;
    }

    public Guest getGuest() {
        return guest;
    }

    public GuestBuilder withProducts(List<Product> productList) {
        guest.setProducts(productList);
        guest.getProducts();

        return this;
    }
}
