package unq.tpi.desapp.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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

    public Loan() {}

    public Loan(Double amount, Integer amountOfInstallments, User user) {
        user.applyLoan(this);
        this.user = user;
        this.fullyPaid = false;
        this.amount = amount;
        this.installments = new ArrayList<Installment>();
        IntStream.rangeClosed(1, amountOfInstallments).forEach(index ->
                installments.add(new Installment(amount / amountOfInstallments, index, this))
        );
    }

    public Integer amountOfPendingInstallments() {
        return (int) installments.stream().filter(Installment::getPaid).count();
    }

    public Installment nextInstallment() {
        Comparator<Installment> comparator = Comparator.comparing( Installment::getNumber );
        Stream<Installment> nonPaidInstallments = installments.stream().filter(installment -> !installment.getPaid());

        return nonPaidInstallments.min(comparator).get();
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
}
