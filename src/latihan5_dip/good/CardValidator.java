package latihan5_dip.good;

// ABSTRACTION (Interface) - High-level module depends on this, not concrete class
public interface CardValidator {

    /**
     * Validate credit card number.
     *
     * Implementasi bisa bermacam-macam, misalnya:
     * - Luhn algorithm validation
     * - Bank Identification Number (BIN) validation
     * - Mock validation for unit testing
     *
     * @param cardNumber nomor kartu yang akan divalidasi
     * @return true jika valid, false jika tidak valid
     */
    boolean validate(String cardNumber);
}
