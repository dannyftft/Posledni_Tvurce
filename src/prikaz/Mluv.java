package prikaz;

import hra.Hra;

public class Mluv extends Prikaz {
    public Mluv(Hra hra) {
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