package latihan5_dip.good;

// Concrete implementation of TransactionLogger
public class DatabaseTransactionLogger implements TransactionLogger {

    @Override
    public void log(String transactionId, double amount, String status) {
        System.out.println("[DatabaseTransactionLogger] Logging to database: "
                + transactionId + ", Amount: " + amount + ", Status: " + status);

        // In real implementation, would save to database:
        // INSERT INTO transactions (id, amount, status, created_at) VALUES (...)
    }
}
