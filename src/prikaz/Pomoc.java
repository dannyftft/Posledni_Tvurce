package prikaz;

import hra.Hra;
import prikaz.konzole.Konzole;

public class Pomoc extends Prikaz {
    public Pomoc(Hra hra, Konzole konzole) {
        super(hra);
        this.konzole = konzole;
    }
    private final Konzole konzole;

    @Override
    public String execute() {
        return konzole.SeznamPrikazu();
    }

    @Override
    public boolean exit() {
        return false;
    }
}