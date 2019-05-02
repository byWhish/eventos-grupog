package unq.tpi.desapp.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unq.tpi.desapp.model.Event;
import unq.tpi.desapp.request.EventRequest;
import unq.tpi.desapp.service.EventService;

@RestController
@RequestMapping("/event")
public class EventWebService {

    @Autowired
    EventService eventService;

    @PostMapping
    public Event postUser(@RequestBody EventRequest eventRequest) {
        return eventService.createEvent(eventRequest);
    }
}
