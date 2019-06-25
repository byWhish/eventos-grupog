package unq.tpi.desapp.model;

import javax.persistence.Entity;

@Entity
public class AccountMaster extends Account{

    @Override
    public void debit(Movement movement) {
    }
}
