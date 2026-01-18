package predmety;

import data.Cteni;
import hra.Hra;

public abstract class Predmet {

    protected String nazev;
    protected String popis;

    public Predmet(String nazev) {
        this.nazev = nazev;
        this.popis = Cteni.PopisPredmetu(nazev);
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
