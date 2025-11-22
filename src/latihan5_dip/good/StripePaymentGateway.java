package latihan5_dip.good;

// Concrete implementation of PaymentGateway using Stripe
public class StripePaymentGateway implements PaymentGateway {

    @Override
    public String charge(String cardNumber, double amount) {
        System.out.println("[StripePaymentGateway] Processing payment via Stripe");
        System.out.println("[StripePaymentGateway] Charging " + amount + " to card: " + cardNumber);

        // Simulate Stripe API call
        String transactionId = "STRIPE-TXN-" + System.currentTimeMillis();
        System.out.println("[StripePaymentGateway] Payment successful - Transaction ID: " + transactionId);

        return transactionId;
    }
}
