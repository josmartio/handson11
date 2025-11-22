package latihan5_dip.good;

// Concrete implementation of FraudDetector
public class RuleBasedFraudDetector implements FraudDetector {

    @Override
    public boolean checkFraud(String cardNumber, double amount) {
        System.out.println("[RuleBasedFraudDetector] Checking fraud with rules. Amount: " + amount);

        // Rule 1: Amount terlalu besar
        if (amount > 1_000_000.0) {
            System.out.println("[RuleBasedFraudDetector] FRAUD DETECTED ✗ - Amount too high!");
            return true;
        }

        // Rule 2 (contoh tambahan): Card number pattern mencurigakan
        if (cardNumber != null && cardNumber.startsWith("0000")) {
            System.out.println("[RuleBasedFraudDetector] FRAUD DETECTED ✗ - Suspicious card prefix!");
            return true;
        }

        // Rule 3 (contoh sederhana): Amount negatif
        if (amount < 0) {
            System.out.println("[RuleBasedFraudDetector] FRAUD DETECTED ✗ - Negative transaction!");
            return true;
        }

        System.out.println("[RuleBasedFraudDetector] No fraud detected ✓");
        return false;
    }
}
