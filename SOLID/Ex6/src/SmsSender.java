public class SmsSender extends NotificationSender {
    public SmsSender(AuditLog audit, SenderConfig config) {
        super(audit, config);
    }

    public boolean validate(Notification n) {
        return n.phone != null;
    }

    @Override
    public void sendNotification(Notification n) {
        if (!validate(n)) {
            System.out.println("SMS ERROR: phone must not be null");
            audit.add("sms failed");
            return;
        }
        System.out.println("SMS -> to=" + n.phone + " body=" + n.body);
        audit.add("sms sent");
    }
}