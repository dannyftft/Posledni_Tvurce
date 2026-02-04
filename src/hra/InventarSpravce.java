package hra;

import predmety.Karta;
import predmety.Predmet;
import java.util.*;

public class InventarSpravce {
    private int kapacita;
    private List<Predmet> predmety;
    private Karta karta;

    public InventarSpravce() {
        this.kapacita = 3;
        this.predmety = new ArrayList<>();
    }

    public boolean pridejPredmet(Predmet predmet) {
        if (predmet.getId().equals("karta")) {
            if (this.karta == null) {
                this.karta = (Karta) predmet;
            } else {
                vylepsiKartu();
            }
            return true;
        }

        if (!predmet.zabiraSlot()) {
            return true;
        }

        if (predmety.size() < kapacita) {
            predmety.add(predmet);
            return true;
        }

        return false;
    }

    public void odeberPredmet(Predmet predmet) {
        predmety.remove(predmet);
        if (predmet.getId().equals("karta")) {
            karta = null;
        }
    }

    public String vypisInventar() {
        String s = "Inventář:\n";

        if (karta != null) {
            s = s + "Karta: " + karta.getNazev() + "\n";
        }

        s = s + "Veci: ";
        for (Predmet p : predmety) {
            s = s + p.getNazev() + ", ";
        }

        if (predmety.isEmpty() && karta == null) {
            s = s + "nic tu neni";
        }

        return s;
    }

    public Predmet getPredmet(String nazev) {
        for (Predmet p : predmety) {
            if (p.getNazev().equalsIgnoreCase(nazev)) {
                return p;
            }
        }
        if (karta != null && karta.getNazev().equalsIgnoreCase(nazev)) {
            return karta;
        }
        return null;
    }

    public boolean obsahujePredmet(String nazev) {
        return getPredmet(nazev) != null;
    }

    public boolean jeVolnySlot() {
        return predmety.size() < kapacita;
    }

    public List<Predmet> getPredmety() {
        return predmety;
    }

    public Karta getKarta() {
        return karta;
    }
    public void vylepsiKartu() {
        if (this.karta != null) {
            this.karta.vylepsit();
        }
    }
}