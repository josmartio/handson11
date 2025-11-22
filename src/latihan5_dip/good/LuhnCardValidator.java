package latihan5_dip.good;

// Concrete implementation of CardValidator
public class LuhnCardValidator implements CardValidator {

    @Override
    public boolean validate(String cardNumber) {
        System.out.println("[LuhnCardValidator] Validating card using Luhn algorithm: " + cardNumber);

        if (cardNumber == null) {
            System.out.println("[LuhnCardValidator] Card is invalid ✗ (null)");
            return false;
        }

        // Remove dash and spaces
        String cleanCard = cardNumber.replace("-", "").replace(" ", "");

        if (cleanCard.length() != 16 || !cleanCard.matches("\\d+")) {
            System.out.println("[LuhnCardValidator] Card is invalid ✗ (not 16 digits)");
            return false;
        }

        // Luhn Algorithm Implementation
        int sum = 0;
        boolean doubleDigit = false;

        for (int i = cleanCard.length() - 1; i >= 0; i--) {
            int digit = cleanCard.charAt(i) - '0';

            if (doubleDigit) {
                digit *= 2;
                if (digit > 9) digit -= 9;
            }

            sum += digit;
            doubleDigit = !doubleDigit;
        }

        boolean isValid = (sum % 10 == 0);

        if (isValid) {
            System.out.println("[LuhnCardValidator] Card is valid ✓");
        } else {
            System.out.println("[LuhnCardValidator] Card is invalid ✗ (Luhn failed)");
        }

        return isValid;
    }
}
