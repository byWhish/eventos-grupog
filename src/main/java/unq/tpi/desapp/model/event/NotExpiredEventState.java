package unq.tpi.desapp.model.event;

import unq.tpi.desapp.model.Guest;

public class NotExpiredEventState extends EventDeadlineState {

    @Override
    protected Boolean canHandle(Event event) {
        return !event.hasExpired();
    }

    @Override
    public void confirmAssistanceFor(Guest guest) {
        guest.secureConfirmAssistance();
    }
}
