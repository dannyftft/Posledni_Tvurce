package prikaz;

import hra.Hra;
import lokace.Lokace;
import predmety.Predmet;
import postavy.Postava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Popis extends Prikaz {
    private Scanner scanner = new Scanner(System.in);

    public Popis(Hra hra) {
        super(hra);
    }

    @Override
    public String execute() {
        Lokace lok = hra.getAktualniLokace();

        List<String> volby = new ArrayList<>();
        List<String> popisy = new ArrayList<>();

        volby.add("Místnost");
        popisy.add(lok.getPopis());

        for (Predmet p : lok.getPredmety()) {
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

        for (Postava p : lok.getPostavy()) {
            volby.add("Postava: " + p.getJmeno());
            popisy.add(p.getPopis());
        }

        System.out.println("Co chceš prozkoumat?");
        for (int i = 0; i < volby.size(); i++) {
            System.out.println((i + 1) + ". " + volby.get(i));
        }

        System.out.print(">> ");
        String vstup = scanner.nextLine().trim();

        try {
            int volba = Integer.parseInt(vstup) - 1;
            if (volba >= 0 && volba < popisy.size()) {
                return "\n" + popisy.get(volba);
            } else {
                return "Neplatná volba.";
            }
        } catch (NumberFormatException e) {
            return "Zadej číslo.";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}