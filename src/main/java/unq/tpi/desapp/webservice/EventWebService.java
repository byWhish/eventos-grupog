package unq.tpi.desapp.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unq.tpi.desapp.model.event.Event;
import unq.tpi.desapp.request.EventRequest;
import unq.tpi.desapp.service.EventService;

@RestController
@RequestMapping("/event")
public class EventWebService {

    @Autowired
    EventService eventService;

    @PostMapping
    public Event postEvent(@RequestBody EventRequest eventRequest) {
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
}
