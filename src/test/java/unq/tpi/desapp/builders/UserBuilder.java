package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.User;

import java.util.Date;

public class UserBuilder {

    User user;

    public UserBuilder() {
        this.user = new User("Nombre", "Apellido", "mail@mail.com", "password", new Date());
    }

    public User getUser() {
        return this.user;
    }

    public UserBuilder withName(String name) {
        this.user.setName(name);

        return this;
    }

    public UserBuilder withSurname(String name) {
        this.user.setSurname(name);

        return this;
    }

    public UserBuilder withEmail(String email) {
        this.user.setEmail(email);

        return this;
    }

    public UserBuilder withPassword(String password) {
        this.user.setPassword(password);

        return this;
    }

    public UserBuilder withBirthDate(Date birthdate) {
        this.user.setBirthDate(birthdate);

        return this;
    }
}
