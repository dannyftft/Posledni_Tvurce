package hra;

import nepratel.Nepritel;
import predmety.Predmet;
import predmety.Trubka;
import predmety.Kamen;
import java.util.Scanner;

public class BojovyManager {
    private Hrac hrac;
    private Nepritel nepritel;
    private boolean jeSouboj;
    private Scanner scanner = new Scanner(System.in);
    private InventarSpravce inventar;

    public BojovyManager() {
        this.jeSouboj = false;
    }

    public void ZacniSouboj(Hrac hrac, Nepritel nepritel, InventarSpravce inventar) {
        this.hrac = hrac;
        this.nepritel = nepritel;
        this.inventar = inventar;
        this.jeSouboj = true;
    }

    // Hlavní menu souboje
    public String provedTah() {
        if (!jeSouboj) {
            return "";
        }

        System.out.println("\nTvůj tah:");
        System.out.println("Jak chceš zaútočit?");
        System.out.println("1. Základní útok (bez zbraně)");

        int pocet = 2;
        Trubka trubka = null;
        Kamen kamen = null;

        // Projde inventář a zjistí jestli je Trubku nebo Kámen
        // Nebude fungovat pokud přidám nový předmět pro boj
        for (Predmet p : inventar.getPredmety()) {
            if (p.getId().equals("trubka")) {
                trubka = (Trubka) p;
                System.out.println(pocet + ". Útok s " + p.getNazev());
                pocet++;
            }
            if (p.getId().equals("kamen")) {
                kamen = (Kamen) p;
                System.out.println(pocet + ". Hodit " + p.getNazev());
                pocet++;
            }
        }

        System.out.print("\nVolba: ");
        int volba = scanner.nextInt();
        scanner.nextLine();

        int bonusUtok;
        Predmet pouzityPredmet = null;

        //malinko blbý ale funguje pokud hráč má jenom kamen bude jako druhá volba pokud má kámen a trubku kámen bude na třetím místě
        // Spočítání sílu útoku
        if (volba == 1) {
            bonusUtok = 0;
        } else if (volba == 2 && trubka != null) {
            bonusUtok = trubka.getBonusSila();
        } else if (volba == 2 && kamen != null) {
            bonusUtok = kamen.getPoskozeni();
            if (nepritel.getId().equals("dron")) {
                bonusUtok *= 2;
            }
            pouzityPredmet = kamen;
        } else if (volba == 3 && kamen != null && trubka != null) {
            bonusUtok = kamen.getPoskozeni();
            if (nepritel.getId().equals("dron")) {
                bonusUtok *= 2;
            }
            pouzityPredmet = kamen;
        } else {
            return "Neplatná volba.";
        }

        String vysledek = UtokHrace(bonusUtok);

        // Pokud použil kámen odstraní se z inventáře
        if (pouzityPredmet != null) {
            inventar.odeberPredmet(pouzityPredmet);
        }

        return vysledek;
    }

    public String UtokHrace(int bonusUtok) {
        if (!jeSouboj) {
            return "Nyní neprobíhá souboj.";
        }

        int poskozeni = hrac.getUtok() + bonusUtok;
        nepritel.poskozeni(poskozeni);

        String vysledek = "Útočíš na " + nepritel.getNazev() + " a způsobíš " + poskozeni + " poškození.\n";

        if (nepritel.jePorazen()) {
            vysledek += nepritel.getNazev() + " byl poražen!";
            jeSouboj = false;
            return vysledek;
        }

        vysledek += nepritel.zobrazStav() + "\n\n";
        vysledek += UtokNepritele();

        return vysledek;
    }

    public String UtokNepritele() {
        if (!jeSouboj || nepritel.jePorazen()) {
            return "";
        }

        int poskozeni = nepritel.getUtok();
        hrac.zran(poskozeni);

        String vysledek = nepritel.getNazev() + " útočí a způsobí " + poskozeni + " poškození.\n";
        vysledek += "Tvoje zdraví: " + hrac.getZdravi() + "/" + hrac.getMaxZdravi();

        if (!hrac.jeNazivu()) {
            vysledek += "\n\nByl jsi poražen!";
            jeSouboj = false;
        }

        return vysledek;
    }

    public String pokusUtek(Hra hra) {
        if (!jeSouboj) {
            return "Nyní neprobíhá souboj.";
        }

        String vysledek = "Utekl jsi ze souboje!";
        jeSouboj = false;

        // I při útěku kontrola jestli v místnosti nejsou další nepřátelé
        vysledek += kontrolaDalsichNepratel(hra);

        return vysledek;
    }

    public String kontrolaDalsichNepratel(Hra hra) {
        String vysledek = "";
        // Vymažení aktuálního nepřítele ze seznamu v místnosti
        hra.getAktualniLokace().getNepratelove().remove(nepritel);

        // Okamžité napadnutí dalšího nepřítele
        if (!hra.getAktualniLokace().getNepratelove().isEmpty()) {
            Nepritel dalsi = hra.getAktualniLokace().getNepratelove().get(0);
            ZacniSouboj(hra.getHrac(), dalsi, hra.getInventar());

            vysledek += "\nV místnosti jsou další nepřátelé! Nemůžeš odejít.";
            vysledek += "\n\n" + dalsi.getNazev() + " tě napadl!\n";
            vysledek += "Zdraví nepřítele: " + dalsi.getZdravi() + "\n";
            vysledek += "Tvoje zdraví: " + hrac.getZdravi() + "/" + hrac.getMaxZdravi();
            vysledek += "\n\nPoužij 'utok' pro útok nebo 'utek' pro pokus o útěk.";
        } else if (nepritel != null && nepritel.jePorazen()) {
            vysledek += "\n\nVšichni nepřátelé v místnosti byli poraženi!";
        }

        if (jeSouboj == false) {
            nepritel = null;
        }

        return vysledek;
    }

    public boolean jeSouboj() {
        return jeSouboj;
    }

    public Nepritel getNepritel() {
        return nepritel;
    }
}