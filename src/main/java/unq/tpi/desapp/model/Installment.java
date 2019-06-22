package unq.tpi.desapp.model;

import unq.tpi.desapp.exception.InsufficientFundsException;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Installment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private Boolean paid;
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;

    private Date paymentDate;

    public Installment() {}

    public Installment(Double amount, Integer number, Loan loan) {
        this.amount = amount;
        this.number = number;
        this.loan = loan;
        this.paid = false;
    }

    public Movement pay() {
        this.paymentDate = new Date();
        Movement movement = generateMovement();
        return movement;
    }

    private Movement generateMovement() {
        User user = loan.getUser();
        try {
            Movement movement = new Movement(
                    user.getAccount(),
                    new Account(),
                    this.amount,
                    "Pago de cuota del prestamo " + loan.getId()
            );
            this.paid = true;
            user.handleDefaultment();
            return movement;
        } catch (InsufficientFundsException ex) {
            user.handleDefaultment();
            throw ex;
        }
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Integer getNumber() {
        return this.number;
    }

    public Long getId() {
        return id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public Boolean expired() {
        return !this.getPaid() && this.getPaymentDate() != null &&(this.getPaymentDate().before(new Date()));
    }
}
