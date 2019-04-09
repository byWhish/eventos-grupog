package unq.tpi.desapp.model;

import java.util.Date;

public class User {
    private String name;
    private String surname;
    private String email;
    private String password;
    private Date birdDate;

    public User(String name, String surname, String email, String password, Date birdDate){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.birdDate = birdDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirdDate() {
        return birdDate;
    }

    public void setBirdDate(Date birdDate) {
        this.birdDate = birdDate;
    }

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
}
