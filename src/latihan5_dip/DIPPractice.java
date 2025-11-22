package latihan5_dip;

// import latihan5_dip.good.*; // Uncomment setelah refactoring selesai

public class DIPPractice {
    public static void main(String[] args) {
        /*
         * LATIHAN 5: DEPENDENCY INVERSION PRINCIPLE (DIP)
         *
         * Definisi:
         * "High-level modules should not depend on low-level modules.
         *  Both should depend on abstractions."
         *
         * Konteks:
         * Payment Processing System - memproses pembayaran online
         *
         * Tujuan Latihan:
         * 1. Memahami masalah tight coupling dengan concrete classes
         * 2. Belajar depend on abstractions (interfaces)
         * 3. Menerapkan dependency injection pattern
         * 4. Merasakan benefits dari loose coupling
         */

        // ===== PART 1: BAD PRACTICE - Melanggar DIP =====
        System.out.println("=== BAD PRACTICE: Melanggar DIP ===\n");

        latihan5_dip.bad.PaymentService badService = new latihan5_dip.bad.PaymentService();
        badService.processPayment("4532-1234-5678-9010", 150000.0, "user@example.com");

        System.out.println("\n--- Analisis Masalah ---");
        System.out.println("PaymentService TIGHTLY COUPLED dengan concrete classes:");
        System.out.println("1. new CardValidator() - depend on concrete class");
        System.out.println("2. new FraudDetector() - depend on concrete class");
        System.out.println("3. new PaymentGateway() - depend on concrete class");
        System.out.println("4. new TransactionLogger() - depend on concrete class");
        System.out.println("5. new NotificationSender() - depend on concrete class");
        System.out.println("\nMasalah:");
        System.out.println("✗ Hard to test - Tidak bisa mock dependencies untuk unit testing");
        System.out.println("✗ Hard to extend - Untuk ganti gateway harus ubah PaymentService");
        System.out.println("✗ Hard to reuse - PaymentService terikat dengan implementasi tertentu");
        System.out.println("✗ Tight coupling - High-level module depend on low-level modules");
        System.out.println("✗ Cannot swap - Tidak bisa ganti Stripe ke PayPal tanpa ubah code");

        System.out.println("\n" + "=".repeat(70));

        // ===== PART 2: GOOD PRACTICE - Mengikuti DIP =====
        System.out.println("\n=== GOOD PRACTICE: Mengikuti DIP ===\n");

        /*
         * INSTRUKSI REFACTORING:
         *
         * 1. Buka folder good/
         * 2. Lengkapi interface dan class berikut:
         *
         *    INTERFACES (Abstractions):
         *
         *    a. CardValidator.java (interface)
         *       - Method: validate(String cardNumber)
         *
         *    b. FraudDetector.java (interface)
         *       - Method: checkFraud(String cardNumber, double amount)
         *
         *    c. PaymentGateway.java (interface)
         *       - Method: charge(String cardNumber, double amount)
         *
         *    d. TransactionLogger.java (interface)
         *       - Method: log(String transactionId, double amount, String status)
         *
         *    e. NotificationSender.java (interface)
         *       - Method: sendNotification(String recipient, String message)
         *
         *    IMPLEMENTATIONS (Concrete Classes):
         *
         *    f. LuhnCardValidator.java (implements CardValidator)
         *       - Implementasi validasi kartu dengan Luhn algorithm
         *
         *    g. RuleBasedFraudDetector.java (implements FraudDetector)
         *       - Implementasi fraud detection dengan rules
         *
         *    h. StripePaymentGateway.java (implements PaymentGateway)
         *       - Implementasi payment gateway menggunakan Stripe
         *
         *    i. DatabaseTransactionLogger.java (implements TransactionLogger)
         *       - Implementasi logging ke database
         *
         *    j. EmailNotificationSender.java (implements NotificationSender)
         *       - Implementasi kirim notifikasi via email
         *
         *    HIGH-LEVEL MODULE:
         *
         *    k. PaymentService.java
         *       - Depend on INTERFACES (abstractions)
         *       - Receive dependencies via CONSTRUCTOR (Dependency Injection)
         *       - Tidak create dependencies sendiri dengan 'new'
         *
         * 3. Setelah selesai, uncomment code di bawah untuk testing
         */

        // UNCOMMENT CODE DI BAWAH SETELAH REFACTORING SELESAI
        /*
        System.out.println("--- Setup 1: Stripe Payment Gateway ---");
        // Create concrete implementations (low-level modules)
        CardValidator cardValidator = new LuhnCardValidator();
        FraudDetector fraudDetector = new RuleBasedFraudDetector();
        PaymentGateway stripeGateway = new StripePaymentGateway();
        TransactionLogger transactionLogger = new DatabaseTransactionLogger();
        NotificationSender notificationSender = new EmailNotificationSender();

        // Inject dependencies into PaymentService (high-level module)
        // PaymentService depend on ABSTRACTIONS, not concrete classes
        PaymentService stripePaymentService = new PaymentService(
            cardValidator,
            fraudDetector,
            stripeGateway,
            transactionLogger,
            notificationSender
        );

        stripePaymentService.processPayment("4532-1234-5678-9010", 150000.0, "user@example.com");

        System.out.println("\n" + "=".repeat(70));
        System.out.println("\n--- Setup 2: PayPal Payment Gateway ---");

        // Bisa dengan mudah ganti implementasi tanpa ubah PaymentService!
        // Cukup ganti PaymentGateway saja
        PaymentGateway paypalGateway = new PayPalPaymentGateway(); // Buat class ini

        PaymentService paypalPaymentService = new PaymentService(
            cardValidator,
            fraudDetector,
            paypalGateway,  // Ganti gateway
            transactionLogger,
            notificationSender
        );

        paypalPaymentService.processPayment("4532-9876-5432-1098", 250000.0, "buyer@example.com");

        System.out.println("\n" + "=".repeat(70));
        System.out.println("\n--- Setup 3: Testing with Mock (for Unit Testing) ---");

        // Untuk unit testing, bisa inject mock objects
        // PaymentService mockService = new PaymentService(
        //     new MockCardValidator(),
        //     new MockFraudDetector(),
        //     new MockPaymentGateway(),
        //     new MockTransactionLogger(),
        //     new MockNotificationSender()
        // );
        // mockService.processPayment("1234-5678-9012-3456", 100000.0, "test@example.com");

        System.out.println("\n--- Keuntungan Setelah Refactoring ---");
        System.out.println("✓ Loose coupling - PaymentService tidak depend on concrete classes");
        System.out.println("✓ Easy to test - Bisa inject mock dependencies untuk unit testing");
        System.out.println("✓ Flexible - Bisa ganti gateway dari Stripe ke PayPal tanpa ubah PaymentService");
        System.out.println("✓ Reusable - PaymentService bisa digunakan dengan berbagai implementasi");
        System.out.println("✓ Follow DIP - High-level module depend on abstractions");
        System.out.println("✓ Open for extension - Mudah tambah payment gateway baru");
        */

        /*
         * EKSPEKTASI OUTPUT:
         *
         * === BAD PRACTICE: Melanggar DIP ===
         *
         * [CardValidator] Validating card: 4532-1234-5678-9010
         * [CardValidator] Card is valid
         * [FraudDetector] Checking fraud for amount: 150000.0
         * [FraudDetector] No fraud detected
         * [PaymentGateway] Charging 150000.0 to card: 4532-1234-5678-9010
         * [PaymentGateway] Payment successful - Transaction ID: TXN-12345
         * [TransactionLogger] Logging transaction: TXN-12345, Amount: 150000.0, Status: SUCCESS
         * [NotificationSender] Sending notification to: user@example.com
         * [NotificationSender] Subject: Payment Successful
         *
         * --- Analisis Masalah ---
         * PaymentService TIGHTLY COUPLED dengan concrete classes:
         * 1. new CardValidator() - depend on concrete class
         * 2. new FraudDetector() - depend on concrete class
         * 3. new PaymentGateway() - depend on concrete class
         * 4. new TransactionLogger() - depend on concrete class
         * 5. new NotificationSender() - depend on concrete class
         *
         * Masalah:
         * ✗ Hard to test - Tidak bisa mock dependencies untuk unit testing
         * ✗ Hard to extend - Untuk ganti gateway harus ubah PaymentService
         * ✗ Hard to reuse - PaymentService terikat dengan implementasi tertentu
         * ✗ Tight coupling - High-level module depend on low-level modules
         * ✗ Cannot swap - Tidak bisa ganti Stripe ke PayPal tanpa ubah code
         *
         * ======================================================================
         *
         * === GOOD PRACTICE: Mengikuti DIP ===
         *
         * --- Setup 1: Stripe Payment Gateway ---
         * [LuhnCardValidator] Validating card using Luhn algorithm: 4532-1234-5678-9010
         * [LuhnCardValidator] Card is valid ✓
         * [RuleBasedFraudDetector] Checking fraud with rules for amount: 150000.0
         * [RuleBasedFraudDetector] No fraud detected ✓
         * [StripePaymentGateway] Processing payment via Stripe
         * [StripePaymentGateway] Charging 150000.0 to card: 4532-1234-5678-9010
         * [StripePaymentGateway] Payment successful - Transaction ID: STRIPE-TXN-12345
         * [DatabaseTransactionLogger] Logging to database: STRIPE-TXN-12345, Amount: 150000.0, Status: SUCCESS
         * [EmailNotificationSender] Sending email to: user@example.com
         * [EmailNotificationSender] Subject: Payment Successful - Amount: Rp 150000.0
         *
         * ======================================================================
         *
         * --- Setup 2: PayPal Payment Gateway ---
         * [LuhnCardValidator] Validating card using Luhn algorithm: 4532-9876-5432-1098
         * [LuhnCardValidator] Card is valid ✓
         * [RuleBasedFraudDetector] Checking fraud with rules for amount: 250000.0
         * [RuleBasedFraudDetector] No fraud detected ✓
         * [PayPalPaymentGateway] Processing payment via PayPal
         * [PayPalPaymentGateway] Charging 250000.0 to card: 4532-9876-5432-1098
         * [PayPalPaymentGateway] Payment successful - Transaction ID: PAYPAL-TXN-67890
         * [DatabaseTransactionLogger] Logging to database: PAYPAL-TXN-67890, Amount: 250000.0, Status: SUCCESS
         * [EmailNotificationSender] Sending email to: buyer@example.com
         * [EmailNotificationSender] Subject: Payment Successful - Amount: Rp 250000.0
         *
         * --- Keuntungan Setelah Refactoring ---
         * ✓ Loose coupling - PaymentService tidak depend on concrete classes
         * ✓ Easy to test - Bisa inject mock dependencies untuk unit testing
         * ✓ Flexible - Bisa ganti gateway dari Stripe ke PayPal tanpa ubah PaymentService
         * ✓ Reusable - PaymentService bisa digunakan dengan berbagai implementasi
         * ✓ Follow DIP - High-level module depend on abstractions
         * ✓ Open for extension - Mudah tambah payment gateway baru
         */
    }
}
