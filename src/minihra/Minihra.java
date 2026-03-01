package minihra;

public interface Minihra {
    /**
     * Spustí minihr a vrátí výsledek.
     *
     * @return {@code true} pokud hráč vyhrál {@code false} pokud prohrál nebo odešel
     */
    boolean spust();

    default String getOdmenaId() {
        return null;
    }
}