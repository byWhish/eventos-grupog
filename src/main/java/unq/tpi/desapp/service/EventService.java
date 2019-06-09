package unq.tpi.desapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unq.tpi.desapp.factory.EventFactory;
import unq.tpi.desapp.model.Guest;
import unq.tpi.desapp.model.event.Event;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.persistence.EventRepository;
import unq.tpi.desapp.request.EventRequest;
import unq.tpi.desapp.request.UserRequest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventFactory eventFactory;

    @Autowired
    private AccountsService accountsService;

    @Autowired
    private GuestService guestService;

    @Transactional
    public Event createEvent(EventRequest eventRequest) {
        Event event = eventRepository.save(requestToEvent(eventRequest));
        event.getGuests().stream().forEach(guest -> guestService.sendInvitationMail(guest));
        return event;
    }

    @Transactional
    public Event findEvent(Long eventId) {
        return eventRepository.findById(eventId).orElseThrow(
                () -> new IllegalArgumentException("Invalid event Id:" + eventId));
    }

    @Transactional
    public void destroy(Long eventId) {
        eventRepository.deleteById(eventId);
    }

    private Event requestToEvent(EventRequest eventRequest) {
        Event event = eventFactory.getEventFromType(eventRequest.getType());
        event.setDescription(eventRequest.getDescription());
        event.setName(eventRequest.getName());
        event.setDeadline(eventRequest.getDeadline());
        event.setProducts(eventRequest.getProducts());
        event.setHeldAt(eventRequest.getHeldAt());

        event.setOwner(getOwnerFromRequest(eventRequest));
        event.setGuests(getGuestsFromRequest(eventRequest, event));
        return event;
    }

    private List<Guest> getGuestsFromRequest(EventRequest eventRequest, Event event) {
        List<User> users = accountsService.findUsersByIds(eventRequest.getUserIds());
        return users.stream().map(
                (user) -> new Guest(event, user)
        ).collect(Collectors.toList());
    }

    private User getOwnerFromRequest(EventRequest eventRequest) {
        Long userId = eventRequest.getOwnerId();
        return accountsService.findUserById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id " + userId));
    }

    @Transactional
    public List<Event> findLastest(Long userId) {
        return eventRepository.findLastest(userId);
    }

    @Transactional
    public List<Event> findOngoing(Long userId) {
        return eventRepository.findOngoing(userId);
    }

    @Transactional
    public List<Event> findPopular() {
        return eventRepository.findPopular();
    }

    public void createEvents(List<EventRequest> events) {
        events.forEach( event -> this.createEvent(event));
    }
}
