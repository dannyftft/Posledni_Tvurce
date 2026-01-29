package prikaz;

import hra.Hra;
import nepratel.Nepritel;

public class Utok extends Prikaz {
    public Utok(Hra hra) {
        super(hra);
    }

    @Override
    public String execute() {
        if (!hra.getBojovyManager().jeSouboj()) {
            return "Nyní neprobíhá souboj.";
        }

        String vysledek = hra.getBojovyManager().provedTah();
        Nepritel aktualniNepritel = hra.getBojovyManager().getNepritel();

        if (aktualniNepritel != null && aktualniNepritel.jePorazen()) {
            vysledek += hra.getBojovyManager().kontrolaDalsichNepratel(hra);
        }

        if (!hra.getHrac().jeNazivu()) {
            hra.setKonec(true);
        }

        return vysledek;
    }

    @Override
    public boolean exit() {
        return false;
    }
}