package prikaz;

import hra.Hra;
import lokace.Lokace;
import predmety.Predmet;
import postavy.Postava;
import nepratel.Nepritel;

public class Prohledej extends Prikaz {

    public Prohledej(Hra hra) {
        super(hra);
    }

    @Override
    public String execute() {
        Lokace lokace = hra.getAktualniLokace();

        String s = "Místnost: " + lokace.getNazev() + "\n";
        s = s + lokace.getPopis() + "\n";

        // Výpis předmětů
        if (!lokace.getPredmety().isEmpty()) {
            s = s + "Věci: ";
            for (Predmet p : lokace.getPredmety()) {
                s = s + p.getNazev() + " ";
            }
            s = s + "\n";
        }

        // Výpis postav
        if (!lokace.getPostavy().isEmpty()) {
            s = s + "Postavy: ";
            for (Postava p : lokace.getPostavy()) {
                s = s + p.getJmeno() + " ";
            }
        }

        /*
        if (!lokace.getNepratelove().isEmpty()) {
            s = s + "NEPRATELE: ";
            for (Nepritel n : lokace.getNepratelove()) {
                s = s + n.getJmeno() + " ";
            }
            s = s + "\n";
        }
         */
        return s;
    }

    @Override
    public boolean exit() {
        return false;
    }
}