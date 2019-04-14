package unq.tpi.desapp.model;

import java.util.List;
import java.util.stream.Collectors;

public class BasketEvent extends Event {

    @Override
    public Double amountToPay(Guest guest) {
        return 0.0;
    }

    @Override
    protected List<Guest> collaboratorsFor(Product product) {
        return super.collaboratorsFor(product).stream()
                .filter(guest -> guest.collaboratesIn(product))
                .collect(Collectors.toList());
    }

}
