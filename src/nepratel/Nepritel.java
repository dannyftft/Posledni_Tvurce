package nepratel;

import hra.Hrac;

public abstract class Nepritel {
    protected String nazev;
    protected String popis;
    protected int zdravi;
    protected int utok;

    public Nepritel(String nazev, int zdravi, int utok) {
        this.nazev = nazev;
        this.zdravi = zdravi;
        this.utok = utok;
    }

    public void poskozeni(int poskozeni) {
        // Odečte poskozeni od zdravi
    }

    public boolean jePorazen() {
        // Vrátí true pokud je zdravi menší než 0
        return false;
    }

    public String zobrazStav() {
        // Vrátí zdravi
        return "";
    }
} //TODO musím zajistit že poškození a zdraví bude vyrovnaný s tím co má hráč