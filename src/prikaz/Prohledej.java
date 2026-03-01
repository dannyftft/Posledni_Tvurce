package prikaz;

import hra.Hra;
import lokace.Lokace;
import predmety.Predmet;
import postavy.Postava;

// Příkaz pro prohledání lokace
public class Prohledej extends Prikaz {

    public Prohledej(Hra hra) {
        super(hra);
    }

    @Override
    // Prohledá aktuální lokaci
    public String execute() {
        Lokace lokace = hra.getAktualniLokace();

        String s = "\nMístnost: " + lokace.getNazev() + "\n";

        // Výpis předmětů
        if (!lokace.getPredmety().isEmpty()) {
            s = s + "Věci: ";
            for (Predmet p : lokace.getPredmety()) {
                s = s + p.getNazev() + ", ";
            }
            s = s + "\n";
        }

        // Výpis postav
        if (!lokace.getPostavy().isEmpty()) {
            s = s + "Postavy: ";
            for (Postava p : lokace.getPostavy()) {
                s = s + p.getJmeno() + ", ";
            }
        }

        if(hra.getAktualniLokace().getId().equals("laborator")){
            s = s + "\nFunkční terminál: Obrazovka slabě bliká, jako by čekala na vstup.";
        }
        return s;
    }

    @Override
    public boolean exit() {
        return false;
    }
}