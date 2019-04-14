package unq.tpi.desapp.model;

public class PartyEvent extends Event {

    public Double amountToPay(Guest guest) {
        return guest.isOwner() ? totalAmount() : 0.0;
    }

}