package unq.tpi.desapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double balance;

    private String alias;

    @OneToOne( mappedBy = "account")
    private User user;

    public void debit(Double amount) throws Exception {
        if ( amount > this.balance ) throw new Exception("Insuficient founds");
        this.balance = this.balance - amount;
    }

    public void credit(Double amount) {
        this.balance = this.balance + amount;
    }

    public Account() {}

    public Account( Long id, String alias, User user ){
        this.id = id;
        this.alias = alias;
        this.user = user;
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
