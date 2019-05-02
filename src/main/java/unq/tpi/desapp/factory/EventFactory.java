package unq.tpi.desapp.factory;

import org.springframework.stereotype.Component;
import unq.tpi.desapp.model.*;

import java.util.HashMap;
import java.util.Map;

@Component
public class EventFactory {

    Map<String, Event> events = new HashMap<>();

    public EventFactory() {
        events.put(BasketEvent.TYPE, new BasketEvent());
        events.put(MoneyCollectionEvent.TYPE, new MoneyCollectionEvent());
        events.put(PartyEvent.TYPE, new PartyEvent());
        events.put(CommonAccountEvent.TYPE, new CommonAccountEvent());
    }

    public Event getEventFromType(String type) {
        return events.get(type);
    }
}
