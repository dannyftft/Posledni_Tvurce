package prikaz;

import hra.Hra;
import prikaz.konzole.Konzole;

// Příkaz pro zobrazení všech možných příkazů
public class Pomoc extends Prikaz {
    public Pomoc(Hra hra, Konzole konzole) {
        super(hra);
        this.konzole = konzole;
    }
    private final Konzole konzole;

    @Override
    public String execute() {
        return "\n"+konzole.SeznamPrikazu();
    }

    @Override
    public boolean exit() {
        return false;
    }
}