package prikaz;

import hra.Hra;
import lokace.Lokace;
import predmety.Predmet;
import minihra.Minihra;
import java.util.Scanner;
import java.util.InputMismatchException;

// Příkaz pro použití předmětu
public class Pouzij extends Prikaz {
    private Scanner scanner = new Scanner(System.in);

    public Pouzij(Hra hra) {
        super(hra);
    }

    @Override
    public String execute() {
        Lokace lokace = hra.getAktualniLokace();
        Minihra minihra = lokace.getMinihra();

        boolean jeTuMinihra = (minihra != null);

        if (hra.getInventar().getPredmety().isEmpty() && !jeTuMinihra) {
            return "\nTady není nic, co bys mohl použít.";
        }

        System.out.println("\nCo chceš použít?");
        int index = 1;

        for (Predmet p : hra.getInventar().getPredmety()) {
            System.out.println(index + ". " + p.getNazev());
            index++;
        }

        if (jeTuMinihra) {
            if (lokace.getId().equals("jidelna")) {
                System.out.println(index + ". Obvod pro kamery");

            } else if(lokace.getId().equals("laborator")) {
                System.out.println(index + ". Terminál");
            } else if(lokace.getId().equals("ridici")){
                System.out.println(index +". Řídící terminál" );
            }
        }

        System.out.print(">>");

        try {
            int volba = scanner.nextInt();
            scanner.nextLine();

            if (volba >= 1 && volba <= hra.getInventar().getPredmety().size()) {
                Predmet vybrany = hra.getInventar().getPredmety().get(volba - 1);
                String vysledek = vybrany.pouzit(hra);

                if (vybrany.jeSpotrebovatelny()) {
                    hra.getInventar().odeberPredmet(vybrany);
                }
                return vysledek;
            }

            if (jeTuMinihra && volba == index) {
                if (minihra.spust()) {
                    lokace.Vyhra();
                    if (minihra.getOdmenaId() != null) {
                        String odmenaId = minihra.getOdmenaId();
                        Predmet odmena = hra.vytvorPredmet(odmenaId);
                        if (odmena != null) {
                            hra.getInventar().pridejPredmet(odmena);
                            return "Získal jsi: " + odmena.getNazev();
                        }
                    }
                }
            }

        } catch (InputMismatchException e) {
            scanner.nextLine();
            return "Neplatná volba.";
        }
        return "\nNeplatná volba.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}