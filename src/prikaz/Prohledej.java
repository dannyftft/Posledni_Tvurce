package prikaz;

import hra.Hra;

public class Prohledej extends Prikaz {
    public Prohledej(Hra hra) {
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