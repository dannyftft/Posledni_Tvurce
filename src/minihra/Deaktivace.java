/*
    Info o příkazů je ve třídě "Lokace"
 */
package minihra;

public class Deaktivace implements Minihra {
    @Override
    public void spust() {

    }

    @Override
    public boolean jeDokoncena() {
        return false;
    }

    @Override
    public boolean getVysledek() {
        return false;
    }
}
