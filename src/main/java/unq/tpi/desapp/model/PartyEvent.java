package unq.tpi.desapp.model;

public class PartyEvent extends Event {

    public PartyEvent(){}

    public PartyEvent(User owner, String name){
        super(owner, name);
    }

    public Double amountToPay(Guest guest) {
        return guest.isOwner() ? totalAmount() : 0.0;
    }

}