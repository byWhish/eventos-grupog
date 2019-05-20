package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.Account;
import unq.tpi.desapp.model.Transfer;

public final class TransferBuilder {

    private Transfer transfer;

    public TransferBuilder() {
        transfer = new Transfer();
        withAmount(0.0);
        withDestination(new AccountBuilder().build());
        withOrigin(new AccountBuilder().build());
    }

    public static TransferBuilder aTransfer() {
        return new TransferBuilder();
    }

    public TransferBuilder withOrigin(Account origin) {
        transfer.setOrigin(origin);
        transfer.getOrigin();
        return this;
    }

    public TransferBuilder withDestination(Account destination) {
        transfer.setDestination(destination);
        transfer.getDestination();
        return this;
    }

    public TransferBuilder withAmount(Double amount) {
        transfer.setAmount(amount);
        transfer.getAmount();
        return this;
    }

    public Transfer build() {
        return transfer;
    }
}
