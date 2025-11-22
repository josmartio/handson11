package latihan5_dip.good;

// ABSTRACTION (Interface)
// High-level module tidak bergantung pada gateway pembayaran tertentu
public interface PaymentGateway {

    /**
     * Charge payment to a credit card.
     *
     * Implementasi bisa bermacam-macam:
     * - Stripe payment gateway
     * - PayPal payment gateway
     * - Midtrans payment gateway
     * - Mock gateway untuk testing
     *
     * @param cardNumber nomor kartu kredit
     * @param amount jumlah uang yang akan ditarik
     * @return transaction ID (biasanya string unik)
     */
    String charge(String cardNumber, double amount);
}
