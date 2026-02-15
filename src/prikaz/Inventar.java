package prikaz;

import hra.Hra;

// Příkaz pro zobrazení inventáře
public class Inventar extends Prikaz {

    public Inventar(Hra hra) {
        super(hra);
    }

    @Override
    // Zobrazí obsah inventáře
    public String execute() {
        return hra.getInventar().vypisInventar();
    }

    @Override
    public boolean exit() {
        return false;
    }
}