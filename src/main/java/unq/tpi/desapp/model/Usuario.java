package unq.tpi.desapp.model;

import java.util.Date;

public class Usuario {
    private String name;
    private String surname;
    private String email;
    private String password;
    private Date birdDate;

    public Usuario(String name, String surname, String email, String password, Date birdDate){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.birdDate = birdDate;
    }
    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }
}
