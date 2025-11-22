package latihan5_dip.good;

// ABSTRACTION (Interface)
// High-level module bergantung pada interface ini, bukan implementasi konkret
public interface FraudDetector {

    /**
     * Check for fraudulent transaction.
     *
     * Implementasi bisa bermacam-macam, misalnya:
     * - Rule-based fraud detection
     * - Machine learning fraud detection
     * - Third-party fraud detection service
     * - Mock detector for testing
     *
     * @param cardNumber nomor kartu kredit
     * @param amount jumlah transaksi
     * @return true jika dicurigai fraud, false jika aman
     */
    boolean checkFraud(String cardNumber, double amount);
}
