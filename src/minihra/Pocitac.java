package minihra;

import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;
import data.Cteni;

// Minihra s počítačem v laboratoři
public class Pocitac implements Minihra {
    private int[] segmenty = new int[9];
    private Scanner scanner = new Scanner(System.in);

    public Pocitac() {
        for (int i = 0; i < 9; i++) segmenty[i] = 1;

        Random rand = new Random();
        int pocetZavad = 3 + rand.nextInt(3);
        for (int i = 0; i < pocetZavad; i++) {
            provedTah(rand.nextInt(9) + 1);
        }
    }

    @Override
    public boolean spust() {
        System.out.println("\n================================================");
        System.out.println("        REKONSTRUKCE ENERGETICKÉHO VEDENÍ         ");
        System.out.println("================================================  ");
        System.out.println(" STAV: Přerušení toku v sekcích (0).              ");
        System.out.println(" DIAGNOSTIKA: Změna napětí v sekci ovlivňuje      ");
        System.out.println("              bezprostředně sousedící spoje.      ");
        System.out.println("================================================  ");

        while (!jeVseAktivni()) {
            vypisVedeni();
            System.out.print("Vyber sekci k rekalibraci (1-9) nebo 0 pro vzdání: ");

            try {
                int volba = scanner.nextInt();
                if (volba == 0) {
                    return false;
                }

                if (volba >= 1 && volba <= 9) {
                    provedTah(volba);
                }
            } catch (InputMismatchException e) {
                System.out.println("Zadej číslo sekce.");
                scanner.nextLine();
            }
        }

        // Pokud je minihra vyhraná spustí se lore část
        if (jeVseAktivni()) {
            vypisVedeni();
            System.out.println("\n[ OK ] Energetický okruh uzavřen. Dveře jsou pod napětím.");

            System.out.println("\n" + Cteni.UvodniDialog("pocitac", "pocitac"));

            boolean prohlizeni = true;
            while (prohlizeni) {
                String[] volby = Cteni.DialogVolby("pocitac", "pocitac");

                System.out.println("\nDATABÁZE:");
                for (int i = 0; i < volby.length; i++) {
                    System.out.println((i + 1) + ". " + volby[i]);
                }
                System.out.println("0. Ukončit terminál");
                System.out.print(">> ");

                try {
                    int volba = scanner.nextInt();
                    scanner.nextLine();

                    if (volba == 0) {
                        prohlizeni = false;
                    } else if (volba > 0 && volba <= volby.length) {
                        String text = Cteni.DialogOdpoved("pocitac", "pocitac", volba);
                        System.out.println("\n" + text);
                    } else {
                        System.out.println("Neplatná volba.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Zadej číslo");
                    scanner.nextLine();
                }
            }
            return true;
        }
        return false;
    }

    private void provedTah(int volba) {
        int i = volba - 1;
        prepni(i);
        if (i > 0) {
            prepni(i - 1);// Před
        }
        if (i < 8) {
            prepni(i + 1); // Za
        }
    }

    private void prepni(int id) {
        segmenty[id] = 1 - segmenty[id];
    }

    private void vypisVedeni() {
        System.out.println("\n    [ZDROJ]");
        System.out.println("      | ");
        System.out.println("     (" + segmenty[0] + ")---(" + segmenty[1] + ")---(" + segmenty[2] + ")  [Sektory 1-3]");
        System.out.println("                  |                                                                      ");
        System.out.println("     (" + segmenty[5] + ")---(" + segmenty[4] + ")---(" + segmenty[3] + ")  [Sektory 4-6]");
        System.out.println("      |                                                                                  ");
        System.out.println("     (" + segmenty[6] + ")---(" + segmenty[7] + ")---(" + segmenty[8] + ")  [Sektory 7-9]");
        System.out.println("                  |                                                                      ");
        System.out.println("                [Cíl]                                                                    ");
    }

    private boolean jeVseAktivni() {
        for (int s : segmenty)
            if (s == 0) {
                return false;
            }
        return true;
    }
}