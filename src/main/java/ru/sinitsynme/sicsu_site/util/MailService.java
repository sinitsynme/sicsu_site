package ru.sinitsynme.sicsu_site.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class MailService {

    private final JavaMailSender emailSender;

    @Autowired
    public MailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendMessage(String to, String subject, String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@sicsu.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    public void sendGreetingMessage(String to, String username, String password) throws MessagingException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg = String.format("<h1><i>Welcome to SICSU!</i></h1>" +
                "<h4>Your username: %s</h4>" +
                "<h4>Your password: %s</h4>", username, password);
        helper.setText(htmlMsg, true);
        helper.setTo(to);
        helper.setSubject("SICSU - Welcome!");
        helper.setFrom("noreply@sicsu.com");
        emailSender.send(mimeMessage);
    }

    public void sendSuccessfulPasswordChangeMessage(String to) throws MessagingException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg = "<h2><i>The account's password has been changed!</i></h2>" +
                "<p>If it wasn't you, then write to site's support<p>";
        helper.setText(htmlMsg, true);
        helper.setTo(to);
        helper.setSubject("SICSU - Change of password!");
        helper.setFrom("noreply@sicsu.com");
        emailSender.send(mimeMessage);
    }

}
