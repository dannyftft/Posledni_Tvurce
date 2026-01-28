package predmety;

import hra.Hra;

public class Deska extends Predmet {
    private int leceni;

    public Deska(int leceni) {
        super("deska","Obvodová deska");
        this.leceni = leceni;
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