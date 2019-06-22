package unq.tpi.desapp.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import unq.tpi.desapp.model.Loan;
import unq.tpi.desapp.service.LoanService;

@Controller
@RequestMapping("api/private/loans")
public class LoanWebService {

    @Autowired
    private LoanService loanService;

    @PostMapping("/{userId}")
    public ResponseEntity<Loan> applyLoan(@PathVariable Long userId) {
        return new ResponseEntity<>(loanService.applyLoan(userId), HttpStatus.CREATED);
    }
}
