package unq.tpi.desapp.webservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unq.tpi.desapp.model.Guest;
import unq.tpi.desapp.request.InvitationRequest;
import unq.tpi.desapp.service.GuestService;

@RestController
public class GuestWebService {

    @Autowired
    GuestService guestService;

    private static final Logger LOGGER = LoggerFactory.getLogger(GuestWebService.class);

    @PostMapping("/inviteUser")
    public Guest inviteUser(@RequestBody InvitationRequest invitationRequest) {
        LOGGER.info("inicia proceso de /inviteUser");
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

    @GetMapping("/amountToPay/{guestId}")
    public Double amountToPay(@PathVariable Long guestId) {
        return guestService.getAmountToPay(guestId);
    }

}