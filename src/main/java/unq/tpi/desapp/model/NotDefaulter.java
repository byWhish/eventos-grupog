package unq.tpi.desapp.model;

public class NotDefaulter extends DefaulterState {

    @Override
    protected Boolean canHandle(User user) {
        return !user.getIsDefaulter();
    }

    @Override
    public void applyLoan(User user, Loan loan) {
        user.applyNotDefaulterLoan(loan);
    }
}
