package unq.tpi.desapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import unq.tpi.desapp.model.Guest;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.model.event.Event;
import unq.tpi.desapp.model.event.PartyEvent;
import unq.tpi.desapp.persistence.GuestRepository;
import unq.tpi.desapp.request.InvitationRequest;

import javax.mail.MessagingException;
import javax.print.Doc;
import javax.transaction.Transactional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Service
public class GuestService {

    @Autowired
    private EventService eventService;

    @Autowired
    private AccountsService accountsService;

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private EmailSender mailSender;

    @Value("${confirmAssistanceUrl}")
    private String confirmAssistanceUrl;

    @Transactional
    public Guest inviteUser(InvitationRequest invitationRequest) {
        Event event = eventService.findEvent(invitationRequest.getEventId());
        User user = accountsService.findUserById(invitationRequest.getUserId()).orElse(null);

        Guest guest = new Guest(event, user);
        guestRepository.save(guest);
        sendInvitationMail(guest);
        return guest;
    }

    public void cancelInvitation(Long guestId) {
        guestRepository.deleteById(guestId);
    }

    @Transactional
    public Guest confirmAssistance(Long guestId) {
        Guest guest = findById(guestId);
        guest.confirmAssistance();
        guestRepository.save(guest);
        return guest;
    }

    @Transactional
    public Guest findById(Long guestId) {
        return guestRepository.findById(guestId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid guest id " + guestId));
    }

    public void sendInvitationMail(Guest guest) {
        User user = guest.getUser();
        Event event = guest.getEvent();
        try {
            mailSender.sendmail(
                    user.getEmail(),
                    "Fuiste invitado al evento " + event.getName(),
                    user.fullName() + " te invito a un evento el dia " + event.getHeldAt() +
                            ". Podes aceptar la invitacion en el siguiente link: " + confirmAssistanceUrl + guest.getId());
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException("No se pudo enviar el mail de invitacion al evento para el guest " + guest.getId());
        }

    }

    @Transactional
    public Double getAmountToPay(Long guestId) {
        Guest guest = this.findById(guestId);
        return guest.amountToPay();
    }
}
