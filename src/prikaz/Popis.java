package prikaz;

import hra.Hra;
import lokace.Lokace;
import predmety.Predmet;
import postavy.Postava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

// Příkaz pro zobrazení popisu předmětu
public class Popis extends Prikaz {
    private Scanner scanner = new Scanner(System.in);

    public Popis(Hra hra) {
        super(hra);
    }

    @Override
    public String execute() {
        Lokace lokace = hra.getAktualniLokace();

        List<String> volby = new ArrayList<>();
        List<String> popisy = new ArrayList<>();

        volby.add("Místnost: "+ lokace.getNazev());
        popisy.add(lokace.getPopis());

        for (Predmet p : lokace.getPredmety()) {
            volby.add("Předmět: " + p.getNazev());
            popisy.add(p.getPopis());
        }

        for (Predmet p : hra.getInventar().getPredmety()) {
            volby.add("Inventář: " + p.getNazev());
            popisy.add(p.getPopis());
        }

        if (hra.getInventar().getKarta() != null) {
            volby.add("Inventář: " + hra.getInventar().getKarta().getNazev());
            popisy.add(hra.getInventar().getKarta().getPopis());
        }

        for (Postava p : lokace.getPostavy()) {
            volby.add("Postava: " + p.getJmeno());
            popisy.add(p.getPopis());
        }

        System.out.println("\nCo chceš prozkoumat?");
        for (int i = 0; i < volby.size(); i++) {
            System.out.println((i + 1) + ". " + volby.get(i));
        }

        System.out.print(">> ");

        int volba;
        try {
            volba = scanner.nextInt() - 1;
            scanner.nextLine();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return "\nNeplatná volba.";
        }

        if (volba >= 0 && volba < popisy.size()) {
            return "\n" + popisy.get(volba);
        } else {
            return "\nNeplatná volba.";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}