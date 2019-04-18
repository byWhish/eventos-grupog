package unq.tpi.desapp.model;

import java.util.Date;

public class Movement {

    public String type;
    public String originId;
    public String destinationId;
    public Double amount;
    public Date timeStamp;
    public Account account;

    public Movement() {}

    public Movement(Account account, String type, String originId, String destinationId, Double amount) {
        this.type = type;
        this.amount = amount;
        this.originId = originId;
        this.destinationId = destinationId;
        this.timeStamp = new Date();
        this.account = account;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
