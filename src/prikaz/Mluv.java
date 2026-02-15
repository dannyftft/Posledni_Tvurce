package prikaz;

import hra.Hra;
import lokace.Lokace;
import postavy.Postava;
import java.util.Scanner;
import java.util.InputMismatchException;

// Příkaz pro zahájení dialogu s postavou
public class Mluv extends Prikaz {
    private Scanner scanner = new Scanner(System.in);

    public Mluv(Hra hra) {
        super(hra);
    }

    @Override
    public String execute() {
        Lokace lokace = hra.getAktualniLokace();

        // Kontrola jestli je v místnosti postava
        if (lokace.getPostavy().isEmpty()) {
            return "\nNikdo tu není. Možná si zkus promluvit se stěnou?";
        }

        // Výběr postavy
        System.out.println("\nS kým chceš mluvit?");
        for (int i = 0; i < lokace.getPostavy().size(); i++) {
            System.out.println((i + 1) + ". " + lokace.getPostavy().get(i).getJmeno());
        }

        System.out.print(">>");

        int volba;
        try {
            volba = scanner.nextInt() - 1;
            scanner.nextLine();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return "\nNeplatná volba.";
        }

        if (volba < 0 || volba >= lokace.getPostavy().size()) {
            return "\nNeplatná volba.";
        }

        Postava postava = lokace.getPostavy().get(volba);

        // Start dialogu
        hra.setVDialogu(true);

        // While běží dokud mluví
        while (hra.jeVDialogu()) {
            String[] volby = postava.getDialogVolby();

            if (volby.length == 0) {
                hra.setVDialogu(false);
                break;
            }

            // Výpis možností
            System.out.println("\nMožnosti:");
            for (int i = 0; i < volby.length; i++) {
                System.out.println((i + 1) + ". " + volby[i]);
            }
            System.out.println("0. Ukončit dialog");

            System.out.print(">>");

            int cislo;
            try {
                cislo = scanner.nextInt();
                scanner.nextLine();

                if (cislo == 0) {
                    hra.setVDialogu(false);
                    return "\nUkončil jsi dialog.";
                }

                String odpoved = postava.getDialogOdpoved(cislo);
                System.out.println("\n" + postava.getJmeno() + ": " + odpoved);

            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Zadej číslo volby nebo 0 pro konec.");
            }
        }

        return "Dialog skončil.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}