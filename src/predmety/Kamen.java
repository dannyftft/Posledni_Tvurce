package predmety;

import hra.Hra;

public class Kamen extends Predmet {
    private int poskozeni;

    public Kamen() {
        super("kamen");
        this.poskozeni = 10; //TODO možná načíst ze souboru
    }

    @Override
    public String pouzit(Hra hra) {
        /*
        Zkontroluje zda probíhá souboj
           Pokud ne: vrátí zprávu že nemůže
           Pokud ano:
              Získá typ nepřítele
              Pokud je Dron: způsobí vetši poškození třeba: poskozeni*2
              Jinak způsobí normální poskozeni
         Vrátí zprávu o výsledku
          */
        return "";
    }

    @Override
    public boolean jeSpotrebovatelny() {
        return true;
    }

    @Override
    public boolean zabiraSlot() {
        return true;
    }
}