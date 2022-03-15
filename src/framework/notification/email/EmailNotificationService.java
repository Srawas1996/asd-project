package framework.notification.email;

import framework.notification.setups.EmailSetup;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class EmailNotificationService {

    public EmailNotificationService() {
    }

    private void sendMail(EmailMessage emailMessage) {

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", EmailSetup.host);
        prop.put("mail.smtp.port", EmailSetup.port);
        prop.put("mail.smtp.ssl.trust", EmailSetup.host);

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EmailSetup.username, EmailSetup.password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EmailSetup.from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailMessage.getTo()));
            message.setSubject(emailMessage.getSubject());


            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(emailMessage.getBody(), "text/html");

            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
//            attachmentBodyPart.attachFile(new File("pom.xml"));

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            multipart.addBodyPart(attachmentBodyPart);

            message.setContent(multipart);

            Transport.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EmailNotificationService emailNotificationService = new EmailNotificationService();
        EmailMessage emailMessage = new EmailMessage("srawaw@miu.edu","Test Mail", "test message");
        emailNotificationService.sendMail(emailMessage);
    }
}
