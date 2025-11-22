package latihan5_dip.good;

// Concrete implementation of NotificationSender
public class EmailNotificationSender implements NotificationSender {

    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("[EmailNotificationSender] Sending email to: " + recipient);
        System.out.println("[EmailNotificationSender] Subject: " + message);

        // In real implementation, would use email service:
        // - SendGrid, Mailgun, AWS SES, etc.
    }
}
