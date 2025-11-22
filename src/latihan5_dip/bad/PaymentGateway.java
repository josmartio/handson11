package latihan5_dip.bad;

// Concrete class (low-level module)
public class PaymentGateway {

    public String charge(String cardNumber, double amount) {
        System.out.println("[PaymentGateway] Charging " + amount + " to card: " + cardNumber);

        // Simulate payment processing
        String transactionId = "TXN-" + System.currentTimeMillis();
        System.out.println("[PaymentGateway] Payment successful - Transaction ID: " + transactionId);

        return transactionId;
    }
}
