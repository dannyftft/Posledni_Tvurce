package prikaz;

import hra.Hra;

public class Nemluv extends Prikaz {
    public Nemluv(Hra hra) {
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