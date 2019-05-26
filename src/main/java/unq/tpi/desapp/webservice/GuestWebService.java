package unq.tpi.desapp.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unq.tpi.desapp.model.Guest;
import unq.tpi.desapp.request.InvitationRequest;
import unq.tpi.desapp.service.GuestService;

@RestController
public class GuestWebService {

    @Autowired
    GuestService guestService;

    @PostMapping("/inviteUser")
    public Guest inviteUser(@RequestBody InvitationRequest invitationRequest) {
        return guestService.inviteUser(invitationRequest);
    }

    @PostMapping("/confirmAssistance/{guestId}")
    public Guest confirmAssistance(@PathVariable Long guestId) {
        return guestService.confirmAssistance(guestId);
    }

    @DeleteMapping("/cancelInvitation/{guestId}")
    public void deleteEvent(@PathVariable Long guestId) {
        guestService.cancelInvitation(guestId);
    }

}