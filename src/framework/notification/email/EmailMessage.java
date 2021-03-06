package framework.notification.email;

public class EmailMessage {
    private String to;
    private String subject;
    private String body;

    public EmailMessage(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

}
