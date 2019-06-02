package unq.tpi.desapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class EmailSender {

    @Autowired
    private JavaMailSender sender;

    private Logger logger = Logger.getGlobal();

    public void sendmail(String mailTo, String subject, String content) throws MessagingException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            try {
                logger.info("cargando parametros para el envio de mail a " + mailTo);
                helper.setTo(mailTo);
                helper.setSubject(subject);
                helper.setText(content);
            } catch (MessagingException e) {
                logger.log(Level.SEVERE, "error al enviar mail de invitacion", e.getCause());
            }

            sender.send(message);
            logger.info("el mail fue enviado correctamente a la casilla " + mailTo);
        };

        scheduler.schedule(task, 3, TimeUnit.SECONDS);
    }
}
