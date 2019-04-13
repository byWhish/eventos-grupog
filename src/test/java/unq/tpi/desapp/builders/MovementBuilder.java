package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.Movement;

import java.util.Date;

public final class MovementBuilder {
    private Movement movement;

    private MovementBuilder() {
        movement = new Movement();
    }

    public static MovementBuilder aMovement() {
        return new MovementBuilder();
    }

    public MovementBuilder withOriginId(String originId) {
        movement.setOriginId(originId);
        return this;
    }

    public MovementBuilder withDestinationId(String destinationId) {
        movement.setDestinationId(destinationId);
        return this;
    }

    public MovementBuilder withAmount(double amount) {
        movement.setAmount(amount);
        return this;
    }

    public MovementBuilder withTimeStamp(Date timeStamp) {
        movement.setTimeStamp(timeStamp);
        return this;
    }

    public Movement build() {
        return movement;
    }
}
