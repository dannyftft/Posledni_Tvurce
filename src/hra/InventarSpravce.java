package hra;

import predmety.Karta;
import predmety.Predmet;
import java.util.*;

// Správce inventáře hráče
public class InventarSpravce {
    private int kapacita;
    private List<Predmet> predmety;
    private Karta karta;

    // Konstruktor vytvoří inventář s kapacitou 3 sloty
    public InventarSpravce() {
        this.kapacita = 3;
        this.predmety = new ArrayList<>();
    }

    // Přidá předmět do inventáře pokud je místo
    public boolean pridejPredmet(Predmet predmet) {
        // Karta je speciální předmět který nezabírá slot
        if (predmet.getId().equals("karta")) {
            if (this.karta == null) {
                this.karta = (Karta) predmet;
            } else {
                // Pokud už kartu má pouze ji vylepší
                vylepsiKartu();
            }
            return true;
        }

        // Předměty které nezabírají slot se přidají automaticky
        if (!predmet.zabiraSlot()) {
            return true;
        }

        // Kontrola volného místa v inventáři
        if (predmety.size() < kapacita) {
            predmety.add(predmet);
            return true;
        }

        return false;
    }

    // Odebere předmět z inventáře
    public void odeberPredmet(Predmet predmet) {
        predmety.remove(predmet);
        if (predmet.getId().equals("karta")) {
            karta = null;
        }
    }

    // Vypíše obsah inventáře jako text
    public String vypisInventar() {
        String s = "\nInventář:\n";

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

    // Najde předmět v inventáři podle názvu
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

    // Kontrola zda inventář obsahuje předmět
    public boolean obsahujePredmet(String nazev) {
        return getPredmet(nazev) != null;
    }

    // Kontrola zda je volný slot v inventáři
    public boolean jeVolnySlot() {
        return predmety.size() < kapacita;
    }

    public List<Predmet> getPredmety() {
        return predmety;
    }

    public Karta getKarta() {
        return karta;
    }

    // Vylepší přístupovou kartu
    public void vylepsiKartu() {
        if (this.karta != null) {
            this.karta.vylepsit();
        }
    }
}