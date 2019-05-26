package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.Account;
import unq.tpi.desapp.model.User;

public final class AccountBuilder {
    private Account account;

    public AccountBuilder() {
        account = new Account();
        withBalance(0.0);
        withAlias("anAlias");
        withId(1L);
    }

    public static AccountBuilder anAccount() {
        return new AccountBuilder();
    }

    public Account emptyAccount() {
        return new AccountBuilder().withAlias("alias").withId((long) 1).withBalance(0.0).build();
    }

    public AccountBuilder withBalance(Double balance) {
        account.setBalance(balance);
        account.getBalance();
        return this;
    }

    public AccountBuilder withId(Long id) {
        account.setId(id);
        account.getId();
        return this;
    }

    public AccountBuilder withAlias(String alias) {
        account.setAlias(alias);
        account.getAlias();
        return this;
    }

    public Account build() {
        return account;
    }
}