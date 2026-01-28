package predmety;

import hra.Hra;

public abstract class Predmet {

    protected String id;
    protected String nazev;
    protected String popis;

    public Predmet(String id, String nazev) {
        this.id = id;
        this.nazev = nazev;
        this.popis = "";
    }

    public String getId() {
        return id;
    }

    public void nastavPopis(String popis) {
        this.popis = popis;
    }

    public abstract String pouzit(Hra hra);
    public abstract boolean jeSpotrebovatelny();
    public abstract boolean zabiraSlot();

    public String getNazev() {
        return nazev;
    }

    public String getPopis() {
        return popis;
    }
}