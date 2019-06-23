package unq.tpi.desapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    public Account origin;

    @OneToOne
    public Account destination;

    public Double amount;
    public Date timeStamp;
    public String description;

    public Movement(Account origin, Account destination, Double amount, String description) {
        this.origin = origin;
        this.destination = destination;
        this.amount = amount;
        this.description = description;
        this.timeStamp = new Date();
        origin.debit(this);
        destination.credit(this);
    }

    public Movement() {}

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Account getOrigin() {
        return origin;
    }

    public void setOrigin(Account origin) {
        this.origin = origin;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Account getDestination() {
        return destination;
    }

    public void setDestination(Account destination) { this.destination = destination; }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
