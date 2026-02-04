package prikaz;

import hra.Hra;
import lokace.Lokace;
import predmety.Predmet;
import predmety.Karta;
import java.util.Scanner;

public class Seber extends Prikaz {
    private Scanner scanner = new Scanner(System.in);

    public Seber(Hra hra) {
        super(hra);
    }

    @Override
    public String execute() {
        Lokace lokace = hra.getAktualniLokace();

        if (lokace.getPredmety().isEmpty()) {
            return "Zde nejsou žádné předměty.";
        }

        System.out.println("Co chceš sebrat?");
        for (int i = 0; i < lokace.getPredmety().size(); i++) {
            System.out.println((i + 1) + ". " + lokace.getPredmety().get(i).getNazev());
        }

        System.out.print(">>");
        int volba = scanner.nextInt() - 1;
        scanner.nextLine();

        if (volba < 0 || volba >= lokace.getPredmety().size()) {
            return "Neplatná volba.";
        }

        Predmet predmet = lokace.getPredmety().get(volba);

        // Speciální hláška pro kartu
        if (predmet.getId().equals("karta")) {
            Karta karta = hra.getInventar().getKarta();

            if (karta != null) {
                hra.getInventar().pridejPredmet(predmet);
                lokace.getPredmety().remove(predmet);
                return "Našel jsi další část přístupového kódu. Karta vylepšena na úroveň " + karta.getUroven() + ".";
            }
        }

        // Standardní sebrání (včetně první karty)
        if (hra.getInventar().pridejPredmet(predmet)) {
            lokace.getPredmety().remove(predmet);
            return "Sebral jsi: " + predmet.getNazev();
        } else {
            return "Inventář je plný!";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}