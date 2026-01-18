package prikaz;

import hra.Hra;

public class Popis extends Prikaz {
    public Popis(Hra hra) {
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