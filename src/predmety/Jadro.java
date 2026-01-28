package predmety;

import hra.Hra;

public class Jadro extends Predmet {
    private int bonusSila;

    public Jadro(int bonusSila) {
        super("jadro","Energetické jádro");
        this.bonusSila = bonusSila;
    }

    @Override
    public String pouzit(Hra hra) {
        // Nabídne volbu:
        // Co chcete udělat s energetickým jádrem?
        // 1. Použít pro zvýšení vlastní síly
        // 2. Opravit robota v místnosti (pokud ve správné lokace)
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