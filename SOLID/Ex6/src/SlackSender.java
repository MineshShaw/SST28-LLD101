public class SlackSender extends NotificationSender {
    public SlackSender(AuditLog audit, SenderConfig config) {
        super(audit, config);
    }

    // Slack requires 'to' to be non-null (channel/user)
    public boolean validate(Notification n) {
        return n.email != null && !n.email.isEmpty();
    }

    @Override
    public void sendNotification(Notification n) {
        if (!validate(n)) {
            System.out.println("SLACK ERROR: missing recipient email");
            audit.add("slack failed");
            return;
        }
        System.out.println("SLACK -> to=" + n.email + " body=" + n.body);
        audit.add("slack sent");
    }
}