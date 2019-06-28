package unq.tpi.desapp.model.event;

import unq.tpi.desapp.model.Account;
import unq.tpi.desapp.model.Guest;

import javax.persistence.*;

@Entity
@DiscriminatorValue(MoneyCollectionEvent.TYPE)
public class MoneyCollectionEvent extends Event {

    public static final String TYPE = "moneyCollection";

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    Account account;

    public MoneyCollectionEvent() {
        super();
        this.account = new Account();
    }

    @Override
    public Double amountToPay(Guest guest) {
        return totalAmount() / collaborators().size();
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}


