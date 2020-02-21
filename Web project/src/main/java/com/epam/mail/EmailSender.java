package com.epam.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * @author ArtSCactus
 * @version 1.0
 */
public class EmailSender {
    private static final String CONFIG_FILE_PATH = "config/mail";
    private Properties config;

    public EmailSender() {
       init();
    }

    private void init(){
        ResourceBundle bundle = PropertyResourceBundle.getBundle(CONFIG_FILE_PATH);
        config = new Properties();
        config.put("mail.smtp.host", bundle.getString("mail.smtp.host"));
        config.put("mail.smtp.socketFactory.port", bundle.getString("mail.smtp.socketFactory.port"));
        config.put("mail.smtp.socketFactory.class", bundle.getString("mail.smtp.socketFactory.class"));
        config.put("mail.smtp.auth", bundle.getString("mail.smtp.auth"));
        config.put("mail.smtp.port", bundle.getString("mail.smtp.port"));
        config.put("mail.from.email", bundle.getString("mail.from.email"));
        config.put("mail.account.name", bundle.getString("mail.account.name"));
        config.put("mail.account.application.password", bundle.getString("mail.account.application.password"));
    }

    public void send(String subject, String text, String toEmail) {
        Session session = Session.getDefaultInstance(config, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(config.getProperty("mail.account.name"),
                        config.getProperty("mail.account.application.password"));
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(config.getProperty("mail.from.email")));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
