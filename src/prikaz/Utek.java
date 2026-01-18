package prikaz;

import hra.Hra;

public class Utek extends Prikaz {
    public Utek(Hra hra) {
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