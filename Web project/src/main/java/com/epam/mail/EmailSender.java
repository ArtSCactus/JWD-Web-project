package com.epam.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.Properties;

/**
 * Email message handler.
 * <p>
 * Contains method ${@code send} messages via email. Configures from file mail.properties.
 *
 * @author ArtSCactus
 * @version 1.0
 */
public class EmailSender {
    private static final String CONFIG_FILE_PATH = "config/mail";
    private Properties config;

    public EmailSender(ServletContext context) {
        init(context);
    }

    private void init(ServletContext context) {
        config = new Properties();
        try {
            config.load(context.getResourceAsStream(CONFIG_FILE_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load email sender config", e);
        }
    }

    /** Sends email from account, that was configured in config file.
     *
     * @param subject title of email message.
     * @param text body of email message.
     * @param toEmail receiver address.
     */
    public void send(String subject, String text, String toEmail) {
        Session session = Session.getDefaultInstance(config, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(config.getProperty("mail.account.name"),
                        config.getProperty("mail.account.password"));
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
