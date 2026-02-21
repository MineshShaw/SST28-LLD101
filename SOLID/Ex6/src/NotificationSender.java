public abstract class NotificationSender {
    protected final AuditLog audit;
    protected final SenderConfig config;

    protected NotificationSender(AuditLog audit, SenderConfig config) {
        this.audit = audit;
        this.config = config;
    }

    public void send(Notification n) {
        if (n.body == null || n.body.isEmpty()) {
            throw new RuntimeException("Notification body cannot be empty");
        }
        if (n.body.length() > config.maxLen) {
            throw new RuntimeException("Notification body cannot be longer than " + config.maxLen);
        }
        sendNotification(n);
    }

    protected abstract void sendNotification(Notification n);
}