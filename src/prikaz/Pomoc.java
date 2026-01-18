package prikaz;

import hra.Hra;

public class Pomoc extends Prikaz {
    public Pomoc(Hra hra) {
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