package unq.tpi.desapp.model;

import java.util.Date;

public class Movement {

    private String originId;
    private String destinationId;
    private double amount;
    private Date timeStamp;

    public Movement() {}

    public Movement(String originId, String destinationId, double amount) {
        this.amount = amount;
        this.originId = originId;
        this.destinationId = destinationId;
        this.timeStamp = new Date();
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
