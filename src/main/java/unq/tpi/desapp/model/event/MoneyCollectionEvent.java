package unq.tpi.desapp.model.event;

import unq.tpi.desapp.model.Account;
import unq.tpi.desapp.model.Guest;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue(MoneyCollectionEvent.TYPE)
public class MoneyCollectionEvent extends Event {

    public static final String TYPE = "moneyCollection";

    @OneToOne
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


