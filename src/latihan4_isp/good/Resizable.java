package latihan4_isp.good;

// Interface untuk capability RESIZING
// HANYA Image yang implement ini
public interface Resizable {

    /*
     * Resize document (for images)
     * Hanya Image yang punya capability ini
     *
     * @param width - New width
     * @param height - New height
     */
    void resize(int width, int height);
}
