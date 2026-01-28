package hra;

import predmety.Karta;
import predmety.Predmet;
import java.util.*;

public class InventarSpravce {
    private int kapacita;
    private List<Predmet> sloty;
    private Karta karta;

    public InventarSpravce() {
        this.kapacita = 3;
        this.sloty = new ArrayList<>();
    }

    public boolean pridejPredmet(Predmet predmet) {
        if (predmet.getId().equals("karta")) {
            this.karta = (Karta) predmet;
            return true;
        }

        if (!predmet.zabiraSlot()) {
            return true;
        }

        if (sloty.size() < kapacita) {
            sloty.add(predmet);
            return true;
        }

        return false;
    }

    public void odeberPredmet(Predmet predmet) {
        sloty.remove(predmet);
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
        for (Predmet p : sloty) {
            s = s + p.getNazev() + ", ";
        }

        if (sloty.isEmpty() && karta == null) {
            s = s + "nic tu neni";
        }

        return s;
    }

    public Predmet getPredmet(String nazev) {
        for (Predmet p : sloty) {
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
        return sloty.size() < kapacita;
    }

    public List<Predmet> getSloty() {
        return sloty;
    }

    public Karta getKarta() {
        return karta;
    }
}