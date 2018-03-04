import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class notification {

    final private static String username = "TestServerByLiz";
    final private static String password = "TestServer2018";

    final private static String mailSender = "TestServerByLiz@gmail.com";
    final private static String mailReceiver = "allwingstosky@gmail.com";

    public static void init(String log) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mailSender));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailReceiver));
            message.setSubject("GitRepo Compilation and Testing Result");
            message.setText(log);
            Transport.send(message);
            System.out.println("Done");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
