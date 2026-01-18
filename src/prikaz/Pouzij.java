package prikaz;

import hra.Hra;

public class Pouzij extends Prikaz {
    public Pouzij(Hra hra) {
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