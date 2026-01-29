package predmety;

import hra.Hra;

public class Jadro extends Predmet {
    private int bonusSila;

    public Jadro(String id, String nazev, int bonusSila) {
        super(id);
        this.nazev = nazev;
        this.bonusSila = bonusSila;
    }

    @Override
    public String pouzit(Hra hra) {
        return "Energetické jádro se používá pro zvýšení síly nebo opravu robota.";
    }

    @Override
    public boolean jeSpotrebovatelny() {
        return true;
    }

    @Override
    public boolean zabiraSlot() {
        return true;
    }

    public int getBonusSila() {
        return bonusSila;
    }
}