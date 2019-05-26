package unq.tpi.desapp.model;

import java.util.Date;

public class Movement {

    public Long originId;
    public Long destinationId;
    public Double amount;
    public Date timeStamp;
    public String description;

    public Movement(Long originId, Long destinationId, Double amount, String description) {
        this.originId = originId;
        this.destinationId = destinationId;
        this.amount = amount;
        this.description = description;
        this.timeStamp = new Date();
    };

    public Movement() {}

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Long getOriginId() {
        return originId;
    }

    public void setOriginId(Long originId) {
        this.originId = originId;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Long destinationId) { this.destinationId = destinationId; }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
