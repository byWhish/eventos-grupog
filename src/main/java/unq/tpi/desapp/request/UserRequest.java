package unq.tpi.desapp.request;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class UserRequest {

    @NotNull(message = "El nombre es necesario")
    @Length(min = 1, max = 30, message = "El nombre debe tener entre 1 y 30 caracteres")
    private String name;

    @NotNull(message = "El apellido es necesario")
    @Length(min = 1, max = 30, message = "El apellido debe tener entre 1 y 30 caracteres")
    private String surname;

    @NotNull(message = "El email es necesario")
    @Length(min = 1, max = 30, message = "El mail debe tener entre 1 y 30 caracteres")
    @Pattern(regexp="^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", message="El mail tiene un formato incorrecto")
    private String email;

    @NotNull(message = "El apellido es necesario")
    private Date birthDate;

    public UserRequest() {};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
