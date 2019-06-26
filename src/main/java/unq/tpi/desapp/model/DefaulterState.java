package unq.tpi.desapp.model;

import java.util.Arrays;
import java.util.List;

public abstract class DefaulterState {

    private final static List<DefaulterState> subclasses = Arrays.asList(new Defaulter(), new NotDefaulter());

    public static DefaulterState stateFor(User user) {
        return subclasses.stream()
                .filter((state) -> state.canHandle(user)).findFirst().get();
    }

    protected abstract Boolean canHandle(User user);

    public abstract void applyLoan(User user, Loan loan);
}
