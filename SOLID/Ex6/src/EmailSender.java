public class EmailSender extends NotificationSender {
    public EmailSender(AuditLog audit, SenderConfig config) {
        super(audit, config);
    }

    public boolean validate(Notification n) {
        return n.email != null && n.email.contains("@");
    }

    @Override
    public void sendNotification(Notification n) {
        if (!validate(n)) {
            System.out.println("EMAIL ERROR: invalid email address");
            audit.add("email failed");
            return;
        }
        System.out.println("EMAIL -> to=" + n.email + " subject=" + n.subject + " body=" + n.body);
        audit.add("email sent");
    }
}