package prikaz;

import hra.Hra;

public class Stav extends Prikaz {
    public Stav(Hra hra) {
        super(hra);
    }

    @Override
    public String execute() {
        return null;
    }

    @Override
    public boolean exit() {
        return false;
    }
}