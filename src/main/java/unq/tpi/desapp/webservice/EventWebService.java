package unq.tpi.desapp.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unq.tpi.desapp.model.event.Event;
import unq.tpi.desapp.request.EventRequest;
import unq.tpi.desapp.service.EventService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventWebService {

    @Autowired
    EventService eventService;

    @PostMapping
    public Event postEvent(@Valid @RequestBody EventRequest eventRequest) {
        return eventService.createEvent(eventRequest);
    }

    @GetMapping("/{eventId}")
    public Event putEvent(@PathVariable Long eventId) {
        return eventService.findEvent(eventId);
    }

    @DeleteMapping("/{eventId}")
    public void deleteEvent(@PathVariable Long eventId) {
        eventService.destroy(eventId);
    }

    @GetMapping("/lastest/{userId}")
    public List<Event> lastestEvents(@PathVariable Long userId) {
        return eventService.findLastest(userId);
    }

    @GetMapping("/ongoing/{userId}")
    public List<Event> ongoingEvents(@PathVariable Long userId) {
        return eventService.findOngoing(userId);
    }

    @GetMapping("/popular")
    public List<Event> popularEvents() {
        return eventService.findPopular();
    }
}
