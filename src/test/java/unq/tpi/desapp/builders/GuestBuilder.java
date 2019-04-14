package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.Event;
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
        guest = new Guest();
        Product product = new ProductBuilder().getProduct();
        User user = new UserBuilder().getUser();

        guest.setConfirmedAssistance(Boolean.TRUE);
        guest.setProducts(Arrays.asList(product));
        guest.setUser(user);
        guest.setEvent(event);
        guest.setId(1);
    }

    public GuestBuilder withConfirmedAssistance(Boolean confirmedAssistance) {
        guest.setConfirmedAssistance(confirmedAssistance);

        return this;
    }

    public Guest getGuest() {
        return guest;
    }

    public GuestBuilder withProducts(List<Product> productList) {
        guest.setProducts(productList);

        return this;
    }
}
