public class Main {
    public static void main(String[] args) {
        System.out.println("=== Notification Demo ===");
        AuditLog audit = new AuditLog();
        SenderConfig config = new SenderConfig();

        Notification n = new Notification("Welcome", "Hello and welcome to SST!", "riya@sst.edu", "9876543210");

        NotificationSender email = new EmailSender(audit, config);
        NotificationSender sms = new SmsSender(audit, config);
        NotificationSender wa = new WhatsAppSender(audit, config);
        NotificationSender slack = new SlackSender(audit, config);

        email.send(n);
        sms.send(n);
        try {
            wa.send(n);
        } catch (Exception ex) {
            System.out.println("WA ERROR: " + ex.getMessage());
            audit.add("WA failed");
        }
        try {
            slack.send(n);
        } catch (Exception ex) {
            System.out.println("SLACK ERROR: " + ex.getMessage());
            audit.add("SLACK failed");
        }

        System.out.println("AUDIT entries=" + audit.size());
    }
}
