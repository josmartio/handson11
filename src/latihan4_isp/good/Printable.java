package latihan4_isp.good;

// Interface untuk capability PRINTING
// PDF, Word, Spreadsheet bisa print. Image tidak.
public interface Printable {

    /*
     * Print document
     * Hanya document yang bisa dicetak yang implement ini
     */
    void print();
}
