package predmety;

import hra.Hra;

public class Trubka extends Predmet {
    private int bonusSila;

    public Trubka(String id, String nazev, int bonusSila) {
        super(id);
        this.nazev = nazev;
        this.bonusSila = bonusSila;
    }

    @Override
    public String pouzit(Hra hra) {
        return "Trubka se používá jen v boji.";
    }

    @Override
    public boolean jeSpotrebovatelny() {
        return false;
    }

    @Override
    public boolean zabiraSlot() {
        return true;
    }

    public int getBonusSila() {
        return bonusSila;
    }
}