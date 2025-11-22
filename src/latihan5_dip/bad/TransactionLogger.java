package latihan5_dip.bad;

// Concrete class (low-level module)
public class TransactionLogger {

    public void log(String transactionId, double amount, String status) {
        System.out.println("[TransactionLogger] Logging transaction: " + transactionId +
                ", Amount: " + amount + ", Status: " + status);
    }
}
