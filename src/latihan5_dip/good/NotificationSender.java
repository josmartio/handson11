package latihan5_dip.good;

// ABSTRACTION (Interface)
// High-level module tidak bergantung pada jenis notifikasi tertentu
public interface NotificationSender {

    /**
     * Send notification to customer.
     *
     * Implementasi bisa berupa:
     * - Email notification
     * - SMS notification
     * - Push notification
     * - WhatsApp notification
     * - Mock sender (untuk testing)
     *
     * @param recipient alamat tujuan (email/nomor HP)
     * @param message pesan notifikasi
     */
    void sendNotification(String recipient, String message);
}
