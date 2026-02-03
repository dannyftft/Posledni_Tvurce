package prikaz;

import hra.Hra;
import lokace.Lokace;
import postavy.Postava;
import java.util.Scanner;

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
            return "Nikdo tu není. Možná si zkus promluvit se stěnou?";
        }

        // Výběr postavy
        System.out.println("S kým chceš mluvit?");
        for (int i = 0; i < lokace.getPostavy().size(); i++) {
            System.out.println((i + 1) + ". " + lokace.getPostavy().get(i).getJmeno());
        }

        System.out.print("Volba: ");
        String vstupPostava = scanner.nextLine().trim().toLowerCase();

        // Pokud hráč napíše nemluv
        if (vstupPostava.equals("nemluv")) {
            return "Ukončil jsi dialog.";
        }

        int volba;
        try {
            volba = Integer.parseInt(vstupPostava) - 1;
        } catch (NumberFormatException e) {
            return "Musíš zadat číslo postavy.";
        }

        if (volba < 0 || volba >= lokace.getPostavy().size()) {
            return "Taková postava tu není.";
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

            System.out.print(">>");
            String vstup = scanner.nextLine().trim().toLowerCase();

            // Pokud hráč napíše nemluv
            if (vstup.equals("nemluv")) {
                hra.setVDialogu(false);
                return "Ukončil jsi dialog.";
            }

            // Zpracování čísla volby
            try {
                int cislo = Integer.parseInt(vstup);
                String odpoved = postava.getDialogOdpoved(cislo);

                System.out.println("\n" + postava.getJmeno() + ": " + odpoved);
            } catch (Exception e) {
                System.out.println("Zadej číslo volby nebo 'nemluv'.");
            }
        }

        return "Dialog skončil.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}