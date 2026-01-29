package predmety;

import hra.Hra;

public class Deska extends Predmet {
    private int leceni;

    public Deska(String id, String nazev, int leceni) {
        super(id);
        this.nazev = nazev;
        this.leceni = leceni;
    }

    @Override
    public String pouzit(Hra hra) {
        hra.getHrac().vylec(leceni);
        return "Použil jsi " + nazev + " a vyléčil ses o " + leceni + " HP.";
    }

    @Override
    public boolean jeSpotrebovatelny() {
        return true;
    }

    @Override
    public boolean zabiraSlot() {
        return true;
    }
}