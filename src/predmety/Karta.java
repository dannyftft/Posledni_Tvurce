package predmety;

import hra.Hra;

public class Karta extends Predmet {
    private int uroven;

    public Karta() {
        super("karta");
        this.uroven = 0;
    }

    @Override
    public String pouzit(Hra hra) {
        // Získá aktuální lokaci: hra.getAktualniLokace()
        // Zkontroluje typ zámku lokace
        // Porovná s úrovní karty
        // Vrátí zprávu o úspěchu/neúspěchu
        return "";
    }

    @Override
    public boolean jeSpotrebovatelny() {
        return false;
    }

    @Override
    public boolean zabiraSlot() {
        return false;
    }

    public void vylepsit() {
    }

    public int getUroven() {
        // Vrátí 1 pokud základní, 2 pokud vylepšená
        return 0;
    }
}
