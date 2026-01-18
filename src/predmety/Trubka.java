package predmety;

import hra.Hra;

public class Trubka extends Predmet {
    private int bonusSila;

    public Trubka() {
        super("trubka");
        this.bonusSila = 15; //TODO možná načíst ze souboru
    }

    @Override
    public String pouzit(Hra hra) {
        // Zkontroluje, zda probíhá souboj
        // Pokud ano: přidá/vynásobí bonusSila k útoku hráče
        // Pokud ne: vrátí něco jako; Nejde ted použít zbraň
        // Vrátí zprávu
        return "";
    }

    @Override
    public boolean jeSpotrebovatelny() {
        return false;
    }

    @Override
    public boolean zabiraSlot() {
        return true;
    }
}