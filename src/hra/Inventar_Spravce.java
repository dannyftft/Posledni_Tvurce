package hra;

import predmety.Karta;
import predmety.Predmet;
import java.util.*;

public class Inventar_Spravce {
    private int kapacita;
    private List<Predmet> sloty;
    private Karta karta;

    public Inventar_Spravce() {
        this.kapacita = 3;
        this.sloty = new ArrayList<>();
    }

    public boolean pridejPredmet(Predmet predmet) {
        // Pokud je to Karta: uloží se do karta
        // Jinak: zkontroluje zda sloty.size() < kapacita
        // Pokud ano: pridá do sloty a vrátí true
        // Pokud ne: vraťí false (plný inventář)
        return false;
    }

    public void odeberPredmet(Predmet predmet) {
        // Odebere předmět ze sloty
    }

    public boolean obsahujePredmet(String nazev) {
        return false;
    }

    public String vypisInventar() {
        // Vrát seznam předmětů v inventáře
        return null;
    }

    public boolean jeVolnySlot() {
        return false;
    }
}