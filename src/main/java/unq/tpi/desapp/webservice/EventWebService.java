package unq.tpi.desapp.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unq.tpi.desapp.model.event.Event;
import unq.tpi.desapp.request.EventRequest;
import unq.tpi.desapp.service.EventService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/private/events")
public class EventWebService {

    @Autowired
    EventService eventService;

    @PostMapping
    public ResponseEntity<Event> postEvent(@Valid @RequestBody EventRequest eventRequest) {
        return new ResponseEntity<>(eventService.createEvent(eventRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<Event> getEvent(@PathVariable Long eventId) {
        return new ResponseEntity<>(eventService.findEvent(eventId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{eventId}")
    public void deleteEvent(@PathVariable Long eventId) {
        eventService.destroy(eventId);
    }

    @GetMapping("/lastest/{userId}")
    public ResponseEntity<List<Event>> lastestEvents(@PathVariable Long userId) {
        return new ResponseEntity<>(eventService.findLastest(userId), HttpStatus.ACCEPTED);
    }

    @GetMapping("/ongoing/{userId}")
    public ResponseEntity<List<Event>> ongoingEvents(@PathVariable Long userId) {
        return new ResponseEntity<>(eventService.findOngoing(userId), HttpStatus.ACCEPTED);
    }

    @GetMapping("/popular")
    public ResponseEntity<List<Event>> popularEvents() {
        return new ResponseEntity<>(eventService.findPopular(), HttpStatus.ACCEPTED);
    }
}
