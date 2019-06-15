package unq.tpi.desapp.factory;

import org.springframework.stereotype.Component;
import unq.tpi.desapp.exception.InvalidEventException;
import unq.tpi.desapp.model.event.*;

import java.util.HashMap;
import java.util.Map;

@Component
public class EventFactory {

    Map<String, Event> events = new HashMap<>();

    public EventFactory() {}

    public Event getEventFromType(String type) {
        populateEvents();
        Event event = events.get(type);
        if (event == null) throw new InvalidEventException("El tipo de evento es incorrecto");
        return event;
    }

    private void populateEvents() {
        events.put(BasketEvent.TYPE, new BasketEvent());
        events.put(MoneyCollectionEvent.TYPE, new MoneyCollectionEvent());
        events.put(PartyEvent.TYPE, new PartyEvent());
        events.put(CommonAccountEvent.TYPE, new CommonAccountEvent());
    }
}
