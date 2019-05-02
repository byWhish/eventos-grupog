package unq.tpi.desapp.model;

import java.util.Date;

public class MoneyCollectionEvent extends Event {

    Account account;

    public MoneyCollectionEvent(){}

    public MoneyCollectionEvent(User owner, String name, Date deadLine, Account account) {
        super(owner, name, deadLine);
        this.account = account;
    }

    @Override
    public Double amountToPay(Guest guest) {
        return totalAmount() / collaborators().size();
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}


