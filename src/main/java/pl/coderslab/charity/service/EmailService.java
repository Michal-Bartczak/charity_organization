package pl.coderslab.charity.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendActivationEmail(String toEmail, String activationLink){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Aktywacja konta");
        message.setText("Kliknij poniższy link, aby aktywować konto:\n" + activationLink);

        javaMailSender.send(message);
    }
}
