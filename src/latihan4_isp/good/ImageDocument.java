package latihan4_isp.good;

// ImageDocument hanya implement 2 capability
// Tidak ada UnsupportedOperationException!
public class ImageDocument implements Readable, Resizable {

    private String filename;

    // Class ini hanya implement 2 interface:
    // 1. Readable  - bisa dibaca/ditampilkan
    // 2. Resizable - bisa diresize (unique untuk image)
    // TIDAK implement Editable, Printable, Calculable

    public ImageDocument(String filename) {
        this.filename = filename;
    }

    @Override
    public void read() {
        System.out.println("[ImageDocument] Reading Image: " + filename);
    }

    @Override
    public void resize(int width, int height) {
        System.out.println("[ImageDocument] Resizing Image: " + filename + " to " + width + "x" + height);
    }
}
