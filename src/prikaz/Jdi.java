package prikaz;

import hra.Hra;
import lokace.Lokace;
import nepratel.Nepritel;
import postavy.Postava;

import java.util.List;
import java.util.Scanner;

public class Jdi extends Prikaz {
    private Scanner scanner = new Scanner(System.in);

    public Jdi(Hra hra) {
        super(hra);
    }

    @Override
    public String execute() {
        if (hra.getBojovyManager().jeSouboj()) {
            return "\nNemůžeš odejít, probíhá souboj!";
        }

        Lokace aktualni = hra.getAktualniLokace();
        List<Lokace> sousedi = aktualni.getSousedniLokace();

        if (sousedi.isEmpty()) {
            return "\nOdtud nelze nikam jít.";
        }

        System.out.println("\nKam chceš jít?");
        for (int i = 0; i < sousedi.size(); i++) {
            Lokace lokace = sousedi.get(i);
            String stavZamku = lokace.jeZamcena() ? " [ZAMČENO]" : "";
            System.out.println((i + 1) + ". " + lokace.getNazev() + stavZamku);
        }

        System.out.print(">>");
        int volba = scanner.nextInt() - 1;
        scanner.nextLine();

        if (volba < 0 || volba >= sousedi.size()) {
            return "\nNeplatná volba.";
        }

        Lokace nova = sousedi.get(volba);

        if (nova.jeZamcena()) {
            int potrebnaUroven = nova.getPozadovanaUrovenKarty();
            int Uroven = 0;

            if (hra.getInventar().getKarta() != null) {
                Uroven = hra.getInventar().getKarta().getUroven();
            }

            //Pokud je potřeba karta (úroveň > 0)
            if (potrebnaUroven > 0) {
                if (Uroven >= potrebnaUroven) {
                    nova.setZamcena(false);
                    System.out.println("\n[ SYSTÉM ] Karta přijata. Dveře byly odemčeny.");
                } else if(Uroven == 0){
                    return "\nDveře vyžadují kartu úrovně " + potrebnaUroven;
                }else {
                    return "\nDveře vyžadují kartu úrovně " + potrebnaUroven + ". Tvá karta má úroveň " + Uroven + ".";
                }
            }
            //Pokud je zamčeno ale úroveň karty je 0 vyžaduje to terminál
            else {
                return "\nDveře jsou mechanicky zablokovány. Musíš najít jiný způsob, jak je otevřít.";
            }
        }

        hra.ZmenaLokace(nova);

        String vysledek = "\nPřicházíš do: " + nova.getNazev() + "\n" + nova.getPopis() + "\n";

        //  Pokud je v nové místnosti aurora hned promluví pokud je podruhé v nové místnosti nepromluví
        if (!nova.auroraUvod()) {
            for (Postava p : nova.getPostavy()) {
                if (p.getId().equals("aurora")) {
                    String uvodniDialog = p.getUvodniDialog(nova.getId());
                    if (!uvodniDialog.isEmpty()) {
                        vysledek += "\nAurora:\n" + uvodniDialog;
                        nova.setAuroraUVod(true);
                    }
                }
            }
        }

        // Souboj
        if (!nova.getNepratelove().isEmpty()) {
            Nepritel nepritel = nova.getNepratelove().get(0);
            hra.getBojovyManager().ZacniSouboj(hra.getHrac(), nepritel, hra.getInventar());

            vysledek += "\n\n" + nepritel.getNazev() + " tě napadl!\n";
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