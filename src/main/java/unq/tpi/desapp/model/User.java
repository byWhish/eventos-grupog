package unq.tpi.desapp.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @Column(unique = true)
    private String email;

    private Date birthDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Loan> loans;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn( name = "account_id")
    private Account account;

    private Boolean isDefaulter;

    public User(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.account = new Account();
        this.isDefaulter = Boolean.FALSE;
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

    public Boolean getIsDefaulter() {
        return isDefaulter;
    }

    public void setIsDefaulter(Boolean isDefaulter) {
        this.isDefaulter = isDefaulter;
    }

    public void applyLoan(Loan loan) {
        getDefaulterState().applyLoan(this);
    }

    private DefaulterState getDefaulterState() {
        return DefaulterState.stateFor(this);
    }

    protected void applyDefaulterLoan() {
        throw new RuntimeException("No se le puede dar un prestamo a un usuario moroso");
    }

    public void applyNotDefaulterLoan() {}

    public void handleDefaultment() {
        Integer amountOfUnpaidInstallments = (int) this.loans.stream().filter(loan -> !loan.getFullyPaid()).flatMap(loan -> loan.getInstallments().stream())
                .filter(Installment::expired).count();
        this.isDefaulter = amountOfUnpaidInstallments > 0;
    }
}
