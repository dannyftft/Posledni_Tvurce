package prikaz;

import hra.Hra;
import lokace.Lokace;
import nepratel.Nepritel;
import java.util.List;
import java.util.Scanner;

public class Jdi extends Prikaz {
    private Scanner scanner;

    public Jdi(Hra hra) {
        super(hra);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String execute() {
        if (hra.getBojovyManager().jeSouboj()) {
            return "Nemůžeš odejít, probíhá souboj!";
        }

        Lokace aktualni = hra.getAktualniLokace();
        List<Lokace> sousedi = aktualni.getSousedniLokace();

        if (sousedi.isEmpty()) {
            return "Odtud nelze nikam jít.";
        }

        System.out.println("Kam chceš jít?");
        for (int i = 0; i < sousedi.size(); i++) {
            System.out.println((i + 1) + ". " + sousedi.get(i).getNazev());
        }

        System.out.print("Volba: ");
        int volba = scanner.nextInt() - 1;
        scanner.nextLine();

        if (volba < 0 || volba >= sousedi.size()) {
            return "Neplatná volba.";
        }

        Lokace nova = sousedi.get(volba);

        int urovenKarty = 0;
        if (hra.getInventar().getKarta() != null) {
            urovenKarty = hra.getInventar().getKarta().getUroven();
        }

        if (!nova.jePristupna(urovenKarty)) {
            return "Dveře jsou zamčené. Potřebuješ kartu vyšší úrovně.";
        }

        hra.ZmenaLokace(nova);
        String vysledek = "";

        if (!nova.getNepratelove().isEmpty()) {
            Nepritel nepritel = nova.getNepratelove().get(0);
            hra.getBojovyManager().ZacniSouboj(hra.getHrac(), nepritel, hra.getInventar());

            vysledek += "\n" + nepritel.getNazev() + " tě napadl!\n";
            vysledek += "Zdraví nepřítele: " + nepritel.getZdravi() + "\n";
            vysledek += "Tvoje zdraví: " + hra.getHrac().getZdravi() + "/" + hra.getHrac().getMaxZdravi();
            vysledek += "\n\nPoužij 'utok' pro útok nebo 'utek' pro pokus o útěk.";
        }

        return vysledek;
    }

    @Override
    public boolean exit() {
        return false;
    }
}