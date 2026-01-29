package predmety;

import hra.Hra;

public class Kamen extends Predmet {
    private int poskozeni;

    public Kamen(String id, String nazev, int poskozeni) {
        super(id);
        this.nazev = nazev;
        this.poskozeni = poskozeni;
    }

    @Override
    public String pouzit(Hra hra) {
        return "Kámen se používá jen v boji ";
    }

    @Override
    public boolean jeSpotrebovatelny() {
        return true;
    }

    @Override
    public boolean zabiraSlot() {
        return true;
    }

    public int getPoskozeni() {
        return poskozeni;
    }
}