package prikaz;

import hra.Hra;

public class Utok extends Prikaz {
    public Utok(Hra hra) {
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