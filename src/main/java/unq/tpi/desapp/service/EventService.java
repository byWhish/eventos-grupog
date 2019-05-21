package unq.tpi.desapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unq.tpi.desapp.factory.EventFactory;
import unq.tpi.desapp.model.event.Event;
import unq.tpi.desapp.model.Guest;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.persistence.EventRepository;
import unq.tpi.desapp.request.EventRequest;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventFactory eventFactory;

    @Autowired
    private UserService userService;

    public Event createEvent(EventRequest eventRequest) {
        Event event = requestToEvent(eventRequest);
        return eventRepository.save(event);
    }

    public Event findEvent(Long eventId) {
        return eventRepository.findById(eventId).orElseThrow(
                () -> new IllegalArgumentException("Invalid event Id:" + eventId));
    }

    public void destroy(Long eventId) {
        eventRepository.deleteById(eventId);
    }

    private Event requestToEvent(EventRequest eventRequest) {
        Event event = eventFactory.getEventFromType(eventRequest.getType());
        event.setDescription(eventRequest.getDescription());
        event.setName(eventRequest.getName());
        event.setDeadline(eventRequest.getDeadline());
        event.setProducts(eventRequest.getProducts());
        event.setOwner(getOwnerFromRequest(eventRequest));

        event.setGuests(getGuestsFromRequest(eventRequest, event));
        return event;
    }

    private List<Guest> getGuestsFromRequest(EventRequest eventRequest, Event event) {
        List<User> users = userService.findUsersByIds(eventRequest.getUserIds());
        return users.stream().map(
                (user) -> new Guest(event, user)
        ).collect(Collectors.toList());
    }

    private User getOwnerFromRequest(EventRequest eventRequest) {
        Integer userId = eventRequest.getOwnerId();
        return userService.findUserById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id " + userId));
    }
}