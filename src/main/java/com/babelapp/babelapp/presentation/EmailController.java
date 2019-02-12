package com.babelapp.babelapp.presentation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@RestController
public class EmailController {
    @PostMapping(value = "/sendemail")
    public String sendEmail(@RequestBody EmailParams emailParams) {
        try {
            sendmail(emailParams);
            return "Email sent successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to send email";
        }
    }

    private void sendmail(EmailParams emailParams) throws AddressException, MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("babelhackfish@gmail.com", "Boston12!");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("babelhackfish@gmail.com", "Babel Chat"));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailParams.getEmail()));
        msg.setSubject("Invitation to join Babel Chat");
        msg.setContent("<p>You have been invited to join a chat, to join enter this code:<br><br>&emsp;&emsp;&emsp;" + emailParams.getChatcode() + "<br><br>at http://chatnative-hs.firebaseapp.com</p>", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("<p>You have been invited to join a chat, to join enter this code:<br><br>&emsp;&emsp;&emsp;" + emailParams.getChatcode() + "<br><br>at http://chatnative-hs.firebaseapp.com</p>", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        msg.setContent(multipart);
        Transport.send(msg);
    }
}