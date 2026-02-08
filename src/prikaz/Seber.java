package prikaz;

import hra.Hra;
import lokace.Lokace;
import predmety.Predmet;
import predmety.Karta;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Seber extends Prikaz {
    private Scanner scanner = new Scanner(System.in);

    public Seber(Hra hra) {
        super(hra);
    }

    @Override
    public String execute() {
        Lokace lokace = hra.getAktualniLokace();

        if (lokace.getPredmety().isEmpty()) {
            return "\nZde nejsou žádné předměty.";
        }

        System.out.println("\nCo chceš sebrat?");
        for (int i = 0; i < lokace.getPredmety().size(); i++) {
            System.out.println((i + 1) + ". " + lokace.getPredmety().get(i).getNazev());
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

        if (volba < 0 || volba >= lokace.getPredmety().size()) {
            return "\nNeplatná volba.";
        }

        Predmet predmet = lokace.getPredmety().get(volba);

        // Speciální hláška pro kartu
        if (predmet.getId().equals("karta")) {
            Karta karta = hra.getInventar().getKarta();

            if (karta != null) {
                hra.getInventar().pridejPredmet(predmet);
                lokace.getPredmety().remove(predmet);
                return "\nNašel jsi další část přístupového kódu. Karta vylepšena na úroveň " + karta.getUroven() + ".";
            }
        }

        // Standardní sebrání (včetně první karty)
        if (hra.getInventar().pridejPredmet(predmet)) {
            lokace.getPredmety().remove(predmet);
            return "\nSebral jsi: " + predmet.getNazev();
        } else {
            return "\nInventář je plný!";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}