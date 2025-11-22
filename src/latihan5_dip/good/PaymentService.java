package latihan5_dip.good;

// High-level module yang DEPEND ON ABSTRACTIONS
// Tidak depend on concrete implementations
public class PaymentService {

    // Depend on ABSTRACTIONS (interfaces)
    private final CardValidator cardValidator;
    private final FraudDetector fraudDetector;
    private final PaymentGateway paymentGateway;
    private final TransactionLogger transactionLogger;
    private final NotificationSender notificationSender;

    // Dependencies di-inject melalui constructor (Dependency Injection)
    public PaymentService(
            CardValidator cardValidator,
            FraudDetector fraudDetector,
            PaymentGateway paymentGateway,
            TransactionLogger transactionLogger,
            NotificationSender notificationSender) {

        this.cardValidator = cardValidator;
        this.fraudDetector = fraudDetector;
        this.paymentGateway = paymentGateway;
        this.transactionLogger = transactionLogger;
        this.notificationSender = notificationSender;
    }

    public void processPayment(String cardNumber, double amount, String customerEmail) {

        // Step 1: Validate card
        if (!cardValidator.validate(cardNumber)) {
            System.out.println("Payment failed: Invalid card");
            return;
        }

        // Step 2: Check fraud
        if (fraudDetector.checkFraud(cardNumber, amount)) {
            System.out.println("Payment failed: Fraud detected");
            return;
        }

        // Step 3: Charge using gateway
        String transactionId = paymentGateway.charge(cardNumber, amount);

        // Step 4: Log the transaction
        transactionLogger.log(transactionId, amount, "SUCCESS");

        // Step 5: Send notification to customer
        notificationSender.sendNotification(customerEmail,
                "Payment Successful - Amount: Rp " + amount);
    }
}
