package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.Account;

public final class AccountBuilder {
    private Account account;

    public AccountBuilder() {
        account = new Account();
    }

    public static AccountBuilder anAccount() {
        return new AccountBuilder();
    }

    public AccountBuilder withBalance(Double balance) {
        account.setBalance(balance);
        return this;
    }

    public AccountBuilder withId(Long id) {
        account.setId(id);
        return this;
    }

    public AccountBuilder withAlias(String alias) {
        account.setAlias(alias);
        return this;
    }

    public AccountBuilder but() {
        return anAccount().withBalance(account.getBalance()).withId(account.getId()).withAlias(account.getAlias());
    }

    public Account build() {
        return account;
    }
}