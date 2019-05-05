package unq.tpi.desapp.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue(PartyEvent.TYPE)
public class PartyEvent extends Event {

    public static final String TYPE = "party";

    public PartyEvent(){}

    public PartyEvent(User owner, String name, Date deadLine){
        super(owner, name, deadLine);
    }

    public Double amountToPay(Guest guest) {
        return guest.isOwner() ? totalAmount() : 0.0;
    }

}