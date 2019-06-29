package unq.tpi.desapp.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import unq.tpi.desapp.model.Loan;

import java.util.List;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {

    @Query(nativeQuery = true, value="SELECT distinct l.* FROM Loan l join " +
            "Installment i ON l.id = i.loan_id " +
            "where i.paid is false ")
    List<Loan> findOngoingLoans();

    @Query(value = "select l from Loan l where l.user.id = :userId order by l.createdAt desc")
    List<Loan> findAllByUser(@Param("userId") Long userId);
}
