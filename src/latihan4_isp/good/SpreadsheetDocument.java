package latihan4_isp.good;

// SpreadsheetDocument adalah full-featured document
// Implement semua capability kecuali Resizable
public class SpreadsheetDocument implements Readable, Editable, Printable, Calculable {

    private String filename;

    // Class ini implement 4 interface:
    // 1. Readable  - bisa dibaca
    // 2. Editable  - bisa diedit
    // 3. Printable - bisa dicetak
    // 4. Calculable - bisa kalkulasi (unique untuk spreadsheet)

    public SpreadsheetDocument(String filename) {
        this.filename = filename;
    }

    @Override
    public void read() {
        System.out.println("[SpreadsheetDocument] Reading Spreadsheet: " + filename);
    }

    @Override
    public void edit(String content) {
        System.out.println("[SpreadsheetDocument] Editing Spreadsheet: " + filename + " with content: " + content);
    }

    @Override
    public void print() {
        System.out.println("[SpreadsheetDocument] Printing Spreadsheet: " + filename);
    }

    @Override
    public void calculate(String formula) {
        System.out.println("[SpreadsheetDocument] Calculating formula: " + formula + " = 5500");
    }
}
