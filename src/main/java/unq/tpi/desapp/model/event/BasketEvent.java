package unq.tpi.desapp.model.event;

import unq.tpi.desapp.model.Guest;
import unq.tpi.desapp.model.Product;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@DiscriminatorValue(BasketEvent.TYPE)
public class BasketEvent extends Event {

    public static final String TYPE = "basket";

    public BasketEvent(){}

    @Override
    public Double amountToPay(Guest guest) {
        return priceForProducts(guest.getProducts());
    }

    @Override
    public List<Guest> collaboratorsFor(Product product) {
        return super.collaboratorsFor(product).stream()
                .filter(guest -> guest.collaboratesIn(product))
                .collect(Collectors.toList());
    }

}
