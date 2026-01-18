package prikaz;

import hra.Hra;

public class Inventar extends Prikaz {
    public Inventar(Hra hra) {
        super(hra);
    }

    @Override
    public String execute() {
        //TODO zobrazí obsah inventáře
        return null;
    }

    @Override
    public boolean exit() {
        return false;
    }
}