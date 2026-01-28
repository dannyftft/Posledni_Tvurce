package prikaz;

import hra.Hra;
import hra.Hrac;

public class Stav extends Prikaz {

    public Stav(Hra hra) {
        super(hra);
    }

    @Override
    public String execute() {
        Hrac h = hra.getHrac();
        return "Stav:\n" +
                "Zdraví: " + h.getZdravi() + "/" + h.getMaxZdravi() + "\n" +
                "Síla: " + h.getSila() + "\n" +
                "Útok: " + h.getUtok();
    }

    @Override
    public boolean exit() {
        return false;
    }
}