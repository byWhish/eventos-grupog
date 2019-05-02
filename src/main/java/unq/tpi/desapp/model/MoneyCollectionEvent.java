package unq.tpi.desapp.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
@DiscriminatorValue(MoneyCollectionEvent.TYPE)
public class MoneyCollectionEvent extends Event {

    public static final String TYPE = "moneyCollection";

    @OneToOne
    @JoinColumn(name = "account_id")
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


