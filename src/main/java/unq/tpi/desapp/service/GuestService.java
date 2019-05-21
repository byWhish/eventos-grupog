package unq.tpi.desapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unq.tpi.desapp.model.Guest;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.model.event.Event;
import unq.tpi.desapp.persistence.GuestRepository;
import unq.tpi.desapp.request.InvitationRequest;

@Service
public class GuestService {

    @Autowired
    EventService eventService;

    @Autowired
    UserService userService;

    @Autowired
    private GuestRepository guestRepository;

    public Guest inviteUser(InvitationRequest invitationRequest) {
        Event event = eventService.findEvent(invitationRequest.getEventId());
        User user = userService.findUserById(invitationRequest.getUserId());

        Guest guest = new Guest(event, user);
        guestRepository.save(guest);
        return guest;
    }

    public void cancelInvitation(Long guestId) {
        guestRepository.deleteById(guestId);
    }

    public Guest confirmAssistance(Long guestId) {
        Guest guest = findById(guestId);
        guest.confirmAssistance();
        return guest;
    }

    public Guest findById(Long guestId) {
        return guestRepository.findById(guestId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid guest id " + guestId));
    }
}
