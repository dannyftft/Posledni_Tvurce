package prikaz;

import hra.Hra;

// Příkaz pro ukončení hry
public class Konec extends Prikaz {
    public Konec(Hra hra) {
        super(hra);
    }

    @Override
    public String execute() {
        return "Hra se úspěšně ukončila.";
    }

    @Override
    public boolean exit() {
        return true;
    }
}