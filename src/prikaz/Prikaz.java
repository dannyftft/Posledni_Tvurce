package prikaz;

import hra.Hra;

// Abstraktní třída pro příkazy
public abstract class Prikaz {
    protected Hra hra;

    public Prikaz(Hra hra) {
        this.hra = hra;
    }

    // Provede příkaz a vrátí výsledek
    public abstract String execute();

    // Zjistí zda příkaz ukončuje hru
    public abstract boolean exit();
}