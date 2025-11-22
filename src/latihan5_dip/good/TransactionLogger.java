package latihan5_dip.good;

// ABSTRACTION (Interface)
// High-level module tidak bergantung pada jenis logger tertentu
public interface TransactionLogger {

    /**
     * Log transaction detail.
     *
     * Implementasi dapat bermacam-macam:
     * - Database logger
     * - File logger
     * - Cloud logger (AWS, GCP)
     * - Mock logger untuk unit testing
     *
     * @param transactionId ID transaksi
     * @param amount jumlah transaksi
     * @param status status transaksi (SUCCESS / FAILED)
     */
    void log(String transactionId, double amount, String status);
}
