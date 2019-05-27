package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.User;

import java.util.Date;

public class UserBuilder {

    User user;

    public UserBuilder() {
        this.user = new User();
        withName("Nombre");
        withSurname("Apellido");
        withEmail("mail@mail.com");
        withBirthDate(new Date());
    }

    public User getUser() {
        return this.user;
    }

    public UserBuilder withName(String name) {
        this.user.setName(name);
        user.getName();
        return this;
    }

    public UserBuilder withSurname(String name) {
        this.user.setSurname(name);
        user.getSurname();
        return this;
    }

    public UserBuilder withEmail(String email) {
        this.user.setEmail(email);
        user.getEmail();
        return this;
    }

    public UserBuilder withBirthDate(Date birthdate) {
        this.user.setBirthDate(birthdate);
        user.getBirthDate();
        return this;
    }
}
