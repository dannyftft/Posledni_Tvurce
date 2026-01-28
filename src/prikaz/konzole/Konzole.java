package prikaz.konzole;

import hra.Hra;
import prikaz.*;

import java.util.HashMap;
import java.util.Scanner;

public class Konzole {
    private Hra hra;
    private boolean exit = false;
    private HashMap<String, Prikaz> mapa = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public Konzole (Hra hra){
        this.hra = hra;
        this.scanner = new Scanner(System.in);
        inicializace();
    }

    private void inicializace() {
        mapa.put("inventar", new Inventar(hra));
        mapa.put("jdi", new Jdi(hra));
        mapa.put("konec",new Konec(hra));
        mapa.put("mluv",new Mluv(hra));
        mapa.put("nemluv",new Nemluv(hra));
        mapa.put("pomoc",new Pomoc(hra));
        mapa.put("popis",new Popis(hra));
        mapa.put("pouzij",new Pouzij(hra));
        mapa.put("prohledej",new Prohledej(hra));
        mapa.put("seber",new Seber(hra));
        mapa.put("stav", new Stav(hra));
        mapa.put("utek", new Utek(hra));
        mapa.put("utok", new Utok(hra));
        mapa.put("zahod", new Zahod(hra));
    }

    private void proved() {
        System.out.print(">>");
        String prikaz = scanner.next();
        prikaz = prikaz.trim().toLowerCase();
        if (mapa.containsKey(prikaz)) {
            System.out.println(">> " + mapa.get(prikaz).execute());
            exit = mapa.get(prikaz).exit();
        } else {
            System.out.println(">> Nedefinovany prikaz");
        }
    }

    private String nactiVstup() {
        // načte jeden příkaz z konzole
        return null;
    }

    public void start() {
        inicializace();
        do {
            proved();
        } while (!exit);
    }
}
