package latihan4_isp;

// import latihan4_isp.good.*; // Uncomment setelah refactoring selesai

import latihan4_isp.bad.ImageDocument;
import latihan4_isp.bad.PdfDocument;
import latihan4_isp.bad.WordDocument;
import latihan4_isp.good.Printable;
import latihan4_isp.good.SpreadsheetDocument;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

public class ISPPractice {
    public static void main(String[] args) {

        /*
         * LATIHAN 4: INTERFACE SEGREGATION PRINCIPLE (ISP)
         *
         * Definisi:
         * "A client should not be forced to depend on methods it does not use."
         *
         * Konteks:
         * Document Management System - mengelola berbagai jenis dokumen
         *
         * Tujuan Latihan:
         * 1. Memahami masalah fat interface
         * 2. Belajar mengidentifikasi capabilities yang berbeda
         * 3. Memisahkan interface besar menjadi interface-interface khusus (capabilities)
         * 4. Melihat manfaat nyata dari ISP
         */

        // ===== PART 1: BAD PRACTICE =====
        System.out.println("=== BAD PRACTICE: Melanggar ISP ===\n");

        System.out.println("--- Testing PDF Document ---");
        latihan4_isp.bad.Document pdf = new latihan4_isp.bad.PdfDocument("Contract.pdf");
        pdf.read();
        pdf.print();

        System.out.println("\nTrying to edit PDF (not supported):");
        try {
            pdf.edit("New content");
        } catch (UnsupportedOperationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\n--- Testing Image Document ---");
        latihan4_isp.bad.Document image = new latihan4_isp.bad.ImageDocument("Photo.jpg");
        image.read();

        System.out.println("\nTrying to print image (not supported):");
        try {
            image.print();
        } catch (UnsupportedOperationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\n--- Analisis Masalah ---");
        System.out.println("Document interface terlalu BESAR (FAT INTERFACE):");
        System.out.println("1. read()       - semua dokumen butuh ✓");
        System.out.println("2. edit()       - hanya Word & Spreadsheet ✗");
        System.out.println("3. print()      - PDF, Word, Spreadsheet butuh (Image tidak) ✗");
        System.out.println("4. calculate()  - hanya Spreadsheet ✗");
        System.out.println("5. resize()     - hanya Image ✗");
        System.out.println("\nPDF & Image dipaksa implement method yang tidak digunakan!");
        System.out.println("Banyak method hanya melempar UnsupportedOperationException!");
        System.out.println("Interface tidak fleksibel → MELANGGAR ISP!");

        System.out.println("\n" + "=".repeat(70));

        // ===== PART 2: GOOD PRACTICE =====
        System.out.println("\n=== GOOD PRACTICE: Mengikuti ISP ===\n");

        /*
         * INSTRUKSI REFACTORING:
         * Lengkapi folder good/ dengan interface:
         *  - Readable
         *  - Editable
         *  - Printable
         *  - Calculable
         *  - Resizable
         *
         * Lengkapi juga implementasi dokumen:
         *  - PdfDocument  → Readable, Printable
         *  - WordDocument → Readable, Editable, Printable
         *  - SpreadsheetDocument → Readable, Editable, Printable, Calculable
         *  - ImageDocument → Readable, Resizable
         *
         * Setelah selesai, uncomment block berikut:
         */

        /*
        System.out.println("--- Testing PDF Document ---");
        PdfDocument goodPdf = new PdfDocument("Contract.pdf");
        goodPdf.read();
        goodPdf.print();
        // goodPdf.edit(); // ERROR: tidak ada method → sesuai ISP

        System.out.println("\n--- Testing Word Document ---");
        WordDocument word = new WordDocument("Report.docx");
        word.read();
        word.edit("Updated content for report");
        word.print();

        System.out.println("\n--- Testing Spreadsheet Document ---");
        SpreadsheetDocument sheet = new SpreadsheetDocument("Budget.xlsx");
        sheet.read();
        sheet.edit("A1: 1000");
        sheet.calculate("SUM(A1:A10)");
        sheet.print();

        System.out.println("\n--- Testing Image Document ---");
        ImageDocument img = new ImageDocument("Photo.jpg");
        img.read();
        img.resize(800, 600);
        // img.print(); // ERROR: tidak ada method print()

        System.out.println("\n--- Polymorphic Usage ---");
        Readable r1 = new Readable("Doc1.pdf") {
            @Override
            public int read(CharBuffer cb) throws IOException {
                return 0;
            }
        };
        Readable r2 = new ImageDocument("Image1.jpg");
        r1.read();
        r2.read();

        List<Printable> printableDocs = new ArrayList<>();
        printableDocs.add(new PdfDocument("Doc.pdf"));
        printableDocs.add(new WordDocument("Report.docx"));
        printableDocs.add(new SpreadsheetDocument("Data.xlsx"));
        // printableDocs.add(new ImageDocument("Photo.jpg")); // ERROR bagus → tidak printable

        System.out.println("\nPrinting all printable documents:");
        for (Printable doc : printableDocs) {
            doc.print();
        }

        System.out.println("\n--- Keuntungan Setelah Refactoring ---");
        System.out.println("✓ Focused: Interface jelas & spesifik");
        System.out.println("✓ Flexible: Class hanya implement yang diperlukan");
        System.out.println("✓ Type-safe: Cek di compile-time");
        System.out.println("✓ Clean: Tidak ada UnsupportedOperationException");
        System.out.println("✓ Extensible: Mudah membuat document type baru");
        */
    }
}
