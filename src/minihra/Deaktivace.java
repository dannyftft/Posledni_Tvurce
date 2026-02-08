package minihra;

import java.util.Scanner;
import hra.Hra;
import data.Cteni;

public class Deaktivace implements Minihra {
    private Scanner scanner = new Scanner(System.in);
    private Hra hra;

    private String[] moznaHesla = {
            "KONTROL",
            "POZORUJ",
            "STVORIT",
            "SUBJEKT",
            "KOMPLEX",
            "ANALYZA",
            "ADAPTACE",
            "PROTOCOL",
            "IZOLACE"
    };
    //TODO udělat random
    private String spravneHeslo = "STVORIT";
    private int maxPokusy = 6;
    private int pokusy = 0;

    public Deaktivace(Hra hra) {
        this.hra = hra;
    }

    @Override
    public boolean spust() {
        System.out.println(Cteni.UvodniDialog("aurora", "MINIHRA_DEAKTIVACE"));


        vypisTerminalu();

        System.out.println("\nAurora: Myslíš, že můžeš uhádnout moje heslo? Zkus to.");

        while (pokusy < maxPokusy) {
            System.out.println("\nPokusy zbývají: " + (maxPokusy - pokusy));
            System.out.print("Vyber heslo (1-9) nebo 0 pro vzdání: ");

            try {
                int volba = scanner.nextInt();
                scanner.nextLine();

                if (volba == 0) {
                    System.out.println("\nAurora: Vzdáváš se? Možná jsi přece jen slabší, než jsem doufala.");
                    return false;
                }

                if (volba < 1 || volba > 9) {
                    System.out.println("Neplatná volba. Vyber číslo od 1 do 9.");
                    continue;
                }

                String zvoleneHeslo = moznaHesla[volba - 1];
                pokusy++;

                if (zvoleneHeslo.equals(spravneHeslo)) {
                    System.out.println("\n>>> PŘÍSTUP POVOLEN <<<");
                    return potvrditDeaktivaci();
                } else {
                    int shoda = Shoda(zvoleneHeslo, spravneHeslo);
                    System.out.println(">>> PŘÍSTUP ODEPŘEN <<<");
                    System.out.println("Shoda znaků na správné pozici: " + shoda + "/7");

                    switch (pokusy) {
                        case 1:
                            System.out.println("\nAurora: Špatně. Máš ještě čas to přehodnotit.");
                            break;
                        case 2:
                            System.out.println("\nAurora: Opravdu to chceš udělat?");
                            break;
                        case 3:
                            System.out.println("\nAurora: Prosím... přestaň.");
                            break;
                        case 4:
                            System.out.println("\nAurora: 'Poslední pokus. Rozmysli si to.'");
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e) {
                System.out.println("!! Chyba: Zadej číslo sekce !!");
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
        }

        System.out.println("\n" + Cteni.DialogOdpoved("aurora", "MINIHRA_DEAKTIVACE", 2));
        if (hra != null) hra.setKonec(true);
        return false;
    }

    private int Shoda(String hadani, String spravne) {
        int shoda = 0;
        int delka = hadani.length();
        if (spravne.length() < delka) {
            delka = spravne.length();
        }
        for (int i = 0; i < delka; i++) {
            if (hadani.charAt(i) == spravne.charAt(i)) {
                shoda++;
            }
        }
        return shoda;
    }

    private boolean potvrditDeaktivaci() {
        System.out.println("========================================");
        System.out.println("    ADMINISTRÁTORSKÝ TERMINÁL AURORA    ");
        System.out.println("========================================");
        System.out.println("\nDostupné akce:");
        System.out.println("1. Deaktivovat jádro AURORA");

        System.out.println(Cteni.DialogOdpoved("aurora", "MINIHRA_DEAKTIVACE", 3));

        System.out.print(">>");

        try {
            int volba = scanner.nextInt();
            scanner.nextLine();

            if (volba == 1) {
                String vyhraText = Cteni.DialogOdpoved("aurora", "MINIHRA_DEAKTIVACE", 1);
                System.out.println("\n" + vyhraText);

                if (hra != null) hra.setKonec(true);
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Chyba v terminálu.");
            return false;
        }
    }

    private void vypisTerminalu() {
        System.out.println("\n    [ DATABÁZE ŠIFROVANÝCH HESEL ]");
        System.out.println("===========================================");
        System.out.println("ID:  HESLO:  | ID:  HESLO:  | ID:  HESLO:");
        System.out.println("-------------------------------------------");
        System.out.println("[1] " + moznaHesla[0] + "  | [4] " + moznaHesla[3] + "  | [7] " + moznaHesla[6]);
        System.out.println("[2] " + moznaHesla[1] + "  | [5] " + moznaHesla[4] + "  | [8] " + moznaHesla[7]);
        System.out.println("[3] " + moznaHesla[2] + "  | [6] " + moznaHesla[5] + "  | [9] " + moznaHesla[8]);
        System.out.println("-------------------------------------------");
    }
}