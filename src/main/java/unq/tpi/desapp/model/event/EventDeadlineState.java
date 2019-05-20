package unq.tpi.desapp.model.event;

import unq.tpi.desapp.model.Guest;

import java.util.Arrays;
import java.util.List;

abstract class EventDeadlineState {

    private final static List<EventDeadlineState> subclasses = Arrays.asList(new ExpiredEventState(), new NotExpiredEventState());

    public static EventDeadlineState stateFor(Event event) {
        return subclasses.stream()
                .filter((state) -> state.canHandle(event)).findFirst().get();
    }

    protected abstract Boolean canHandle(Event event);

    public abstract void confirmAssistanceFor(Guest guest);
}
