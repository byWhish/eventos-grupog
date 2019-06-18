package unq.tpi.desapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class EmailSender {

    @Autowired
    private JavaMailSender sender;

    @Value("${mail.enabled}")
    private Boolean mailSendingEnabled;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailSender.class);

    public void sendmail(String mailTo, String subject, String content) throws MessagingException {
        if (!mailSendingEnabled) return;
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            try {
                LOGGER.info("cargando parametros para el envio de mail a " + mailTo);
                helper.setTo(mailTo);
                helper.setSubject(subject);
                helper.setText(content);
            } catch (MessagingException e) {
                LOGGER.error("error al enviar mail de invitacion", e.getCause());
            }

            sender.send(message);
            LOGGER.info("el mail fue enviado correctamente a la casilla " + mailTo);
        };

        scheduler.schedule(task, 3, TimeUnit.SECONDS);
    }
}
