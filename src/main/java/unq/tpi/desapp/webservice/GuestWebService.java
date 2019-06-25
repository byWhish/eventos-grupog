package unq.tpi.desapp.webservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unq.tpi.desapp.model.Guest;
import unq.tpi.desapp.model.event.Event;
import unq.tpi.desapp.request.InvitationRequest;
import unq.tpi.desapp.response.GuestResponse;
import unq.tpi.desapp.service.GuestService;

@RestController
public class GuestWebService {

    @Autowired
    GuestService guestService;

    private static final Logger LOGGER = LoggerFactory.getLogger(GuestWebService.class);

    @PostMapping("/api/private/inviteUser")
    public Guest inviteUser(@RequestBody InvitationRequest invitationRequest) {
        LOGGER.info("inicia proceso de /inviteUser");
        return guestService.inviteUser(invitationRequest);
    }

    @PostMapping("/api/private/confirmAssistance/{guestId}")
    public GuestResponse confirmAssistance(@PathVariable Long guestId) {
        return guestService.confirmAssistance(guestId);
    }

    @PostMapping("/api/public/confirmAssistance")
    public GuestResponse confirmAssistanceWithHash(@RequestParam String hash) {
        return guestService.confirmAssistanceWithHash(hash);
    }

    @PostMapping("/api/private/payEvent/{guestId}")
    public boolean payEvent(@PathVariable Long guestId) throws Exception{
        return guestService.payEvent(guestId);
    }

    @DeleteMapping("/api/private/cancelInvitation/{guestId}")
    public void deleteInvitation(@PathVariable Long guestId) {
        guestService.cancelInvitation(guestId);
    }

    @GetMapping("/api/private/amountToPay/{guestId}")
    public Double amountToPay(@PathVariable Long guestId) {
        return guestService.getAmountToPay(guestId);
    }

}