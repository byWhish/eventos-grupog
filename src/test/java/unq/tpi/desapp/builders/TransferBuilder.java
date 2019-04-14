package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.Account;
import unq.tpi.desapp.model.Transfer;

public final class TransferBuilder {

    private Transfer transfer;

    public TransferBuilder() {
        transfer = new Transfer();
    }

    public static TransferBuilder aTransfer() {
        return new TransferBuilder();
    }

    public TransferBuilder withOrigin(Account origin) {
        transfer.setOrigin(origin);
        return this;
    }

    public TransferBuilder withDestination(Account destination) {
        transfer.setDestination(destination);
        return this;
    }

    public TransferBuilder withAmount(Double amount) {
        transfer.setAmount(amount);
        return this;
    }

    public Transfer build() {
        return transfer;
    }
}
