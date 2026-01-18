package hra;

import lokace.*;
import prikaz.Prikaz;

public class Hra {
    private Hrac hrac;
    private Lokace aktualniLokace;
    private BojovyManager bojovyManager;
    private Inventar_Spravce inventar;
    private boolean konec;

    public Hra() {
        this.hrac = new Hrac();
        this.bojovyManager = new BojovyManager();
        this.inventar = new Inventar_Spravce();
        this.konec = false;
    }

    public void start() {
        vytvorMapu();
        // vytvoří mapu a hráče a nastaví počáteční lokaci
    }

    public void vytvorMapu() {
        // Vytvoří všechny lokace a jejich propojení
    }

    public void ZmenaLokace(Lokace novaLokace) {
        // Změní aktualniLokace
        // Zobrazí popis nové lokace
    }

    public Hrac getHrac() {
        return hrac;
    }

    public Lokace getAktualniLokace() {
        return aktualniLokace;
    }

    public BojovyManager getBojovyManager() {
        return bojovyManager;
    }

    public Inventar_Spravce getInventar() {
        return inventar;
    }

    public boolean jeKonec() {
        return konec;
    }
}