package prikaz;

import hra.Hra;
import lokace.Lokace;
import predmety.Predmet;
import minihra.Minihra;

import java.util.Scanner;

public class Pouzij extends Prikaz {
    private Scanner scanner = new Scanner(System.in);

    public Pouzij(Hra hra) {
        super(hra);
    }

    @Override
    public String execute() {
        Lokace lokace = hra.getAktualniLokace();
        Minihra minihra = hra.getAktualniLokace().getMinihra();
        boolean jeTuPc = (minihra != null);

        if (hra.getInventar().getPredmety().isEmpty() && !jeTuPc) {
            return "Tady není nic, co bys mohl použít.";
        }

        System.out.println("Co chceš použít?");
        int index = 1;

        for (Predmet p : hra.getInventar().getPredmety()) {
            System.out.println(index + ". " + p.getNazev());
            index++;
        }

        if (jeTuPc) {
            System.out.println(index + " Použít terminál");
        }

        System.out.print("Volba: ");
        try {
            int volba = scanner.nextInt();
            scanner.nextLine();

            if (volba >= 1 && volba <= hra.getInventar().getPredmety().size()) {
                Predmet predmet = hra.getInventar().getPredmety().get(volba - 1);
                String vysledek = predmet.pouzit(hra);

                if (predmet.jeSpotrebovatelny()) {
                    hra.getInventar().odeberPredmet(predmet);
                }
                return vysledek;
            }


            else if (volba == index) {
                if (minihra.spust()) {
                    lokace.Vyhra();
                } else {
                    return "Nepodařilo se systémy nahodit.";
                }
            }

        } catch (Exception e) {
            scanner.nextLine();
            return "Chyba: Zadej platné číslo ze seznamu.";
        }

        return "Neplatná volba.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}