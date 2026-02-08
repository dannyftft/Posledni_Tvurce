package prikaz;

import hra.Hra;

public class Nemluv extends Prikaz {
    public Nemluv(Hra hra) {
        super(hra);
    }

    @Override
    public String execute() {
        if (hra.jeVDialogu()) {
            hra.setVDialogu(false);
            return "\nDialog byl ukončen.";
        }
        return "\nS nikým teď nemluvíš.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}