package prikaz;

import hra.Hra;

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