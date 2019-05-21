package unq.tpi.desapp.model;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double balance;

    private String alias;

    @OneToOne( mappedBy = "account")
    private User user;

    public void debit(Movement movement) throws Exception {
        if ( movement.amount > this.balance ) throw new Exception("Insuficient founds");
        this.balance = this.balance - movement.amount;
    }

    public void credit(Movement movement) {
        this.balance = this.balance + movement.amount;
    }

    public Account() {}

    public Account(User user) {
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User users) {
        this.user = user;
    }
}
