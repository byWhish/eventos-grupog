package unq.tpi.desapp.model;

import unq.tpi.desapp.exception.InsufficientFundsException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;


@Entity
@Inheritance
@DiscriminatorColumn(name="type")
public class Account {

    public static final Long EVENTOS_GRUPOG_ID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double balance;

    private String alias;

    public void debit(Movement movement) {
        if ( movement.amount > this.balance ) throw new InsufficientFundsException("Insuficient founds");
        this.balance = this.balance - movement.amount;
    }

    public void credit(Movement movement) {
        this.balance = this.balance + movement.amount;
    }

    public Account() {
        this.balance = 0.0;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void applyLoan(Loan loan) {
        this.balance += loan.getAmount();
    }
}
