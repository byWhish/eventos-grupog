package unq.tpi.desapp.model;

import java.util.Date;

public class PartyEvent extends Event {

    public PartyEvent(){}

    public PartyEvent(User owner, String name, Date deadLine){
        super(owner, name, deadLine);
    }

    public Double amountToPay(Guest guest) {
        return guest.isOwner() ? totalAmount() : 0.0;
    }

}