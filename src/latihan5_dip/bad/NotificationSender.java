package latihan5_dip.bad;

// Concrete class (low-level module)
public class NotificationSender {

    public void sendNotification(String recipient, String message) {
        System.out.println("[NotificationSender] Sending notification to: " + recipient);
        System.out.println("[NotificationSender] Subject: " + message);
    }
}
