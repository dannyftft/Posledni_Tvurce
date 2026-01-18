package prikaz;

import hra.Hra;

public abstract class Prikaz {
    protected Hra hra;

    public Prikaz(Hra hra) {
        this.hra = hra;
    }

    public abstract String execute();

    public abstract boolean exit();
}
