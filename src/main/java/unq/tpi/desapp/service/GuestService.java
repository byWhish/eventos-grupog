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
import unq.tpi.desapp.response.GuestResponse;

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
        User user = accountsService.findUserById(invitationRequest.getUserId());

        Guest guest = new Guest(event, user);
        guestRepository.save(guest);
        sendInvitationMail(guest);
        return guest;
    }

    public void cancelInvitation(Long guestId) {
        guestRepository.deleteById(guestId);
    }

    @Transactional
    public GuestResponse confirmAssistance(Long guestId) {
        Guest guest = findById(guestId);
        return confirmAssistanceFor(guest);
    }

    @Transactional
    public GuestResponse confirmAssistanceWithHash(String hash) {
        Guest guest = guestRepository.findByHash(hash).orElseThrow(() -> new IllegalArgumentException("No se encontro guest con el hash " + hash));
        return confirmAssistanceFor(guest);
    }

    private GuestResponse confirmAssistanceFor(Guest guest) {
        guest.confirmAssistance();
        guestRepository.save(guest);
        guest.getEvent();
        return new GuestResponse(guest, guest.getEvent());
    }

    @Transactional
    public Guest findById(Long guestId) {
        return guestRepository.findById(guestId)
                .orElseThrow(() -> new IllegalArgumentException("No se encontro guest con el id " + guestId));
    }

    @Transactional
    public void sendInvitationMail(Guest guest) {
        User user = guest.getUser();
        Event event = guest.getEvent();
        guest.generateHash();
        try {
            mailSender.sendmail(
                    user.getEmail(),
                    "Fuiste invitado al evento " + event.getName(),
                    user.fullName() + " te invito a un evento el dia " + event.getHeldAt() +
                            ". Podes aceptar la invitacion en el siguiente link: " + confirmAssistanceUrl + "?hash=" + guest.getHash());
        } catch (MessagingException e) {
            throw new RuntimeException("No se pudo enviar el mail de invitacion al evento para el guest " + guest.getId());
        }

    }

    @Transactional
    public Double getAmountToPay(Long guestId) {
        Guest guest = this.findById(guestId);
        return guest.amountToPay();
    }
}
