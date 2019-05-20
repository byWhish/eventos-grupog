package unq.tpi.desapp.model.event;

import unq.tpi.desapp.model.Guest;

public class ExpiredEventState extends EventDeadlineState {

    public final static String CANNOT_CONFIRM_ASSISTANCE = "No se puede confirmar asistencia pasada la deadline del evento";

    @Override
    protected Boolean canHandle(Event event) {
        return event.hasExpired();
    }

    @Override
    public void confirmAssistanceFor(Guest guest) {
        throw new RuntimeException(CANNOT_CONFIRM_ASSISTANCE);
    }
}
