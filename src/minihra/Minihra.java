package minihra;

public interface Minihra {
    // True pokud hráč vyhrál false pokud prohrál nebo odešel.
    boolean spust();

    default String getOdmenaId() {
        return null;
    }
}