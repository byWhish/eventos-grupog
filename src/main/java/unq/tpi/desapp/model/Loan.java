package unq.tpi.desapp.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private Double amount;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "loan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Installment> installments;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Boolean fullyPaid;

    private Date createdAt;

    public Loan() {}

    public Loan(Double amount, Integer amountOfInstallments, User user) {
        this.user = user;
        this.fullyPaid = false;
        this.amount = amount;
        this.createdAt = new Date();
        user.applyLoan(this);
        this.installments = new ArrayList<Installment>();
        IntStream.rangeClosed(1, amountOfInstallments).forEach(index ->
                installments.add(new Installment(amount / amountOfInstallments, index, this))
        );
    }

    public Integer amountOfPendingInstallments() {
        return (int) installments.stream().filter(Installment::getPaid).count();
    }

    public List<Installment> installmentsToPay() {
        List<Installment> installments = expiredInstallments();
        Installment nextInstallment = nextInstallment();
        if (nextInstallment != null) installments.add(nextInstallment);
        return installments;
    }

    private List<Installment> expiredInstallments() {
        return installments.stream().filter(Installment::expired).collect(Collectors.toCollection(ArrayList::new));
    }

    private Installment nextInstallment() {
        Comparator<Installment> comparator = Comparator.comparing( Installment::getNumber );
        Stream<Installment> nonPaidInstallments = installments.stream().filter(installment -> !installment.getPaid());

        return nonPaidInstallments.min(comparator).orElse(null);
    }

    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public List<Installment> getInstallments() {
        return installments;
    }

    public User getUser() {
        return user;
    }

    public Boolean getFullyPaid() {
        return fullyPaid;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Double getDebt() {
        Double debt = installmentsToPay().stream().mapToDouble(installment -> installment.getAmount()).sum();
        return debt;
    }

    public Long getAmountOfInstallmentsToPay() {
        return installmentsToPay().stream().count();
    }

    public Long getAmountOfRemainingInstallments() {
        return installments.stream().filter(installment -> installment.getPaymentDate() == null).count();
    }
}
