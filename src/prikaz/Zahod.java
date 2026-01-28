package prikaz;

import hra.Hra;
import lokace.Lokace;
import predmety.Predmet;
import java.util.Scanner;

public class Zahod extends Prikaz {
    private Scanner scanner;

    public Zahod(Hra hra) {
        super(hra);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String execute() {

        if (hra.getInventar().getPredmety().isEmpty()) {
            return "Nemáš u sebe žádné předměty.";
        }

        System.out.println("Co chceš zahodit?");
        for (int i = 0; i < hra.getInventar().getPredmety().size(); i++) {
            System.out.println((i + 1) + ". " +
                    hra.getInventar().getPredmety().get(i).getNazev());
        }

        System.out.print("Volba: ");
        int volba = scanner.nextInt() - 1;
        scanner.nextLine();

        if (volba < 0 || volba >= hra.getInventar().getPredmety().size()) {
            return "Neplatná volba.";
        }

        Predmet predmet = hra.getInventar().getPredmety().get(volba);

        hra.getInventar().odeberPredmet(predmet);

        Lokace lokace = hra.getAktualniLokace();
        lokace.pridejPredmet(predmet);

        return "Zahodil jsi: " + predmet.getNazev();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
