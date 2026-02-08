package minihra;

import java.util.Scanner;

public class Logicka implements Minihra {
    private Scanner scanner = new Scanner(System.in);

    private boolean[] uzly = {false, false, false, false};
    //TODO změnit na random
    private int[] spravnePoradi = {1, 2, 3, 4};
    private int aktualniKrok = 0;

    @Override
    public boolean spust() {
        System.out.println("Oprava obvodu:");
        System.out.println("Aurora: Obvod je poškozený. Musíš aktivovat uzly ve správném pořadí.");
        System.out.println("Jeden chybný krok a celý systém se resetuje.");

        while (aktualniKrok < 4) {
            zobrazStav();

            System.out.println("\nKterý uzel chceš aktivovat? 1-4 nebo 0 pro vzdání");
            System.out.print(">>");

            int volba = scanner.nextInt();
            scanner.nextLine();

            if (volba == 0) {
                return false;
            }

            try {
                if (volba < 1 || volba > 4) {
                    System.out.println("Neplatný uzel. Vyber 1-4.");
                } else {
                    if (volba == spravnePoradi[aktualniKrok]) {
                        uzly[volba - 1] = true;
                        aktualniKrok++;
                        System.out.println("Uzel " + volba + " aktivován.");

                        if (aktualniKrok == 4) {
                            zobrazStav();
                            System.out.println("\nObvod obnoven! Skříň se odemyká...");
                            return true;
                        }
                    } else {
                        System.out.println("Špatný uzel! Systém se resetuje.");
                        resetUzly();
                        aktualniKrok = 0;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Zadej číslo uzlu.");
            }
        }
        return false;
    }

    private void zobrazStav() {
        System.out.println("\nKamerový obvod:");
        for (int i = 0; i < 4; i++) {
            String stav = uzly[i] ? "[ON]" : "[OFF]";
            System.out.println("Uzel " + (i + 1) + ": " + stav);
        }
        System.out.println("Postup: " + aktualniKrok + "/4");
    }

    private void resetUzly() {
        uzly[0] = false;
        uzly[1] = false;
        uzly[2] = false;
        uzly[3] = false;
    }

    @Override
    public String getOdmenaId() {
        return "trubka";
    }
}