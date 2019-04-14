package unq.tpi.desapp.model;

public class MoneyCollectionEvent extends Event {

    @Override
    public Double amountToPay(Guest guest) {
        return totalAmount() / collaborators().size();
    }
}