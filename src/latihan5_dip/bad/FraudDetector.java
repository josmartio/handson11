package latihan5_dip.bad;

// Concrete class (low-level module)
public class FraudDetector {

    public boolean checkFraud(String cardNumber, double amount) {
        System.out.println("[FraudDetector] Checking fraud for amount: " + amount);

        // Simple rule: flag if amount > 1,000,000
        if (amount > 1000000.0) {
            System.out.println("[FraudDetector] FRAUD DETECTED - Amount too high!");
            return true;
        }

        System.out.println("[FraudDetector] No fraud detected");
        return false;
    }
}
