package prikaz;

import hra.Hra;

public class Zahod extends Prikaz {
    public Zahod(Hra hra) {
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