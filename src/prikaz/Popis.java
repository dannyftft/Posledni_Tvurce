package prikaz;

import hra.Hra;

public class Popis extends Prikaz {
    public Popis (Hra hra){
        super(hra);
    }

    @Override
    public String execute() {
        return hra.getAktualniLokace().getPopis();
    }

    @Override
    public boolean exit() {
        return false;
    }
}