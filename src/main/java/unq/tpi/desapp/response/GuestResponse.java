package unq.tpi.desapp.response;

import unq.tpi.desapp.model.Guest;
import unq.tpi.desapp.model.event.Event;

public class GuestResponse {
    Guest guest;
    Event event;

    public GuestResponse(Guest guest, Event event) {
        this.guest = guest;
        this.event = event;
    }

    public Guest getGuest() {
        return guest;
    }

    public Event getEvent() {
        return event;
    }
}
