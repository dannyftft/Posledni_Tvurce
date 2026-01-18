package predmety;

import hra.Hra;
import postavy.Robot;
import postavy.Postava;
import lokace.Lokace;

public class Jadro extends Predmet {
    private int bonusSila;

    public Jadro() {
        super("jadro");
        this.bonusSila = 10;    //TODO možná načíst ze souboru/ možná poskozeni*sila místo sčítání
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