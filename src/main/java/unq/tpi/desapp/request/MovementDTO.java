package unq.tpi.desapp.request;

import java.util.Date;

public class MovementDTO {

    public Long originId;
    public Long destinationId;
    public Double amount;
    public String description;

    public MovementDTO(Long originId, Long destinationId, Double amount, String description) {
        this.originId = originId;
        this.destinationId = destinationId;
        this.amount = amount;
        this.description = description;
    };

    public MovementDTO() {}

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
