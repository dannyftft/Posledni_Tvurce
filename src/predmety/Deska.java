package predmety;

import hra.Hra;

public class Deska extends Predmet {
    private int leceni;

    public Deska() {
        super("deska");
        this.leceni = 30; //TODO možná načíst ze souboru
    }

    @Override
    public String pouzit(Hra hra) {
        // Obnoví zdraví hráče
        return "";
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