package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.Account;
import unq.tpi.desapp.model.Movement;

import java.util.Date;

public final class MovementBuilder {
    private Movement movement;

    public MovementBuilder() {
        movement = new Movement();
        withAmount(0.0);
        withDestinationId(AccountBuilder.anAccount().build());
        withOriginId(AccountBuilder.anAccount().build());
        withTimeStamp(new Date());
    }

    public static MovementBuilder aMovement() {
        return new MovementBuilder();
    }

    public MovementBuilder withOriginId(Account originId) {
        movement.setOrigin(originId);
        movement.getOrigin();
        return this;
    }

    public MovementBuilder withDestinationId(Account destinationId) {
        movement.setDestination(destinationId);
        movement.getDestination();
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
