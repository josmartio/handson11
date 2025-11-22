package latihan5_dip.bad;

// Concrete class (low-level module)
public class CardValidator {

    public boolean validate(String cardNumber) {
        System.out.println("[CardValidator] Validating card: " + cardNumber);

        // Simple validation: check if not null and has correct length
        if (cardNumber == null || cardNumber.replace("-", "").length() != 16) {
            System.out.println("[CardValidator] Card is invalid");
            return false;
        }

        System.out.println("[CardValidator] Card is valid");
        return true;
    }
}
