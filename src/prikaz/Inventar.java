package prikaz;

import hra.Hra;

public class Inventar extends Prikaz {

    public Inventar(Hra hra) {
        super(hra);
    }

    @Override
    public String execute() {
        return hra.getInventar().vypisInventar();
    }

    @Override
    public boolean exit() {
        return false;
    }
}