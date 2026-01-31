package prikaz;

import hra.Hra;
import predmety.Predmet;
import java.util.Scanner;

public class Pouzij extends Prikaz {
    private Scanner scanner = new Scanner(System.in);

    public Pouzij(Hra hra) {
        super(hra);
    }

    @Override
    public String execute() {
        if (hra.getInventar().getPredmety().isEmpty()) {
            return "Nemáš žádné předměty k použití.";
        }

        System.out.println("Který předmět chceš použít?");
        for (int i = 0; i < hra.getInventar().getPredmety().size(); i++) {
            Predmet p = hra.getInventar().getPredmety().get(i);
            System.out.println((i + 1) + ". " + p.getNazev());
        }

        System.out.print("Volba: ");
        int volba = scanner.nextInt() - 1;
        scanner.nextLine();

        if (volba < 0 || volba >= hra.getInventar().getPredmety().size()) {
            return "Neplatná volba.";
        }

        Predmet predmet = hra.getInventar().getPredmety().get(volba);
        String vysledek = predmet.pouzit(hra);

        if (predmet.jeSpotrebovatelny()) {
            hra.getInventar().odeberPredmet(predmet);
        }

        return vysledek;
    }

    @Override
    public boolean exit() {
        return false;
    }
}