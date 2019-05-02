package unq.tpi.desapp.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@DiscriminatorValue(BasketEvent.TYPE)
public class BasketEvent extends Event {

    public static final String TYPE = "basket";

    public BasketEvent(){}

    public BasketEvent(User owner, String name, Date deadLine) {
        super(owner, name, deadLine);
    }

    @Override
    public Double amountToPay(Guest guest) {
        return priceForProducts(guest.getProducts());
    }

    @Override
    protected List<Guest> collaboratorsFor(Product product) {
        return super.collaboratorsFor(product).stream()
                .filter(guest -> guest.collaboratesIn(product))
                .collect(Collectors.toList());
    }

}
