package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.Movement;

import java.util.Date;

public final class MovementBuilder {
    private Movement movement;

    public MovementBuilder() {
        movement = new Movement();
        withAmount(0.0);
        withDestinationId(1L);
        withOriginId(2L);
        withTimeStamp(new Date());
    }

    public static MovementBuilder aMovement() {
        return new MovementBuilder();
    }

    public MovementBuilder withOriginId(Long originId) {
        movement.setOriginId(originId);
        movement.getOriginId();
        return this;
    }

    public MovementBuilder withDestinationId(Long destinationId) {
        movement.setDestinationId(destinationId);
        movement.getDestinationId();
        return this;
    }

    public MovementBuilder withAmount(Double amount) {
        movement.setAmount(amount);
        movement.getAmount();
        return this;
    }

    public MovementBuilder withTimeStamp(Date timeStamp) {
        movement.setTimeStamp(timeStamp);
        movement.getTimeStamp();
        return this;
    }

    public MovementBuilder withDescription(String description) {
        movement.setDescription(description);
        return this;
    }

    public Movement build() {
        return movement;
    }
}
