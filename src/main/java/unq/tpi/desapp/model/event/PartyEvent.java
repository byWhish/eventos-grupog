package unq.tpi.desapp.model.event;

import unq.tpi.desapp.model.Guest;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(PartyEvent.TYPE)
public class PartyEvent extends Event {

    public static final String TYPE = "party";

    public PartyEvent(){}

    public Double amountToPay(Guest guest) {
        return totalAmount();
    }

}