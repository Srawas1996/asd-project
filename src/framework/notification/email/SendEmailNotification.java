package framework.notification.email;

public class SendEmailNotification implements Notifications{
    private EmailMessage emailMessage;

    public SendEmailNotification(EmailMessage emailMessage) {
        this.emailMessage = emailMessage;
    }
    

    @Override
    public void send() {
        System.out.println(
                "Email To: " + emailMessage.getTo() + "\n" +
                        "Email Subject: " + emailMessage.getSubject() + "\n" +
                        "Email Body: " + emailMessage.getBody()
        );
    }
}
