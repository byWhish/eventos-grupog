package unq.tpi.desapp.model;

import javax.persistence.*;
import java.util.Date;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @Column(unique = true)
    private String email;

    private String password;

    private Date birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn( name = "account_id")
    private Account account;

    public User(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.account = new Account();
    }

    public User(){}

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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

    public Long getId() { return id; }

    public String fullName() {
        return name + " " + surname;
    }
}
