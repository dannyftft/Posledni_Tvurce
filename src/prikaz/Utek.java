package prikaz;

import hra.Hra;
import hra.BojovyManager;
import java.util.Random;

public class Utek extends Prikaz {
    private Random random;

    public Utek(Hra hra) {
        super(hra);
        this.random = new Random();
    }

    @Override
    public String execute() {
        BojovyManager boj = hra.getBojovyManager();

        if (!boj.jeSouboj()) {
            return "\nNyní neprobíhá souboj.";
        }

        int sance = random.nextInt(100);

        if (sance < 50) {
            String vysledek = "\nPokusil ses utéct, ale nepodařilo se!\n";
            vysledek += boj.UtokNepritele();

            if (!hra.getHrac().jeNazivu()) {
                hra.setKonec(true);
            }

            return vysledek;
        } else {
            return boj.pokusUtek(hra);
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}