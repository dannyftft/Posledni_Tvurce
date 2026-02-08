package predmety;

import hra.Hra;
import hra.HraData;
import postavy.PoskozenyRobot;
import postavy.Postava;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Jadro extends Predmet {

    private final int bonusSila;

    public Jadro(HraData.PredmetData data) {
        super(data);
        this.bonusSila = data.bonus_sila;
    }

    @Override
    public String pouzit(Hra hra) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Co chceš udělat s energetickým jádrem?");
        System.out.println("1. Použít pro zvýšení vlastní síly");

        PoskozenyRobot robot = null;
        for (Postava p : hra.getAktualniLokace().getPostavy()) {
            if (p.getId().equals("poskozenyRobot")) {
                robot = (PoskozenyRobot) p;
                if (!robot.muzeMluvit()) {
                    System.out.println("2. Opravit robota v místnosti");
                    break;
                }
            }
        }

        System.out.print(">> ");

        int volba;
        try {
            volba = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return "\nNeplatná volba. Musíš zadat číslo.";
        }

        if (volba == 1) {
            hra.getHrac().zvysSilu(bonusSila);
            return "\nPoužil jsi energetické jádro a zvýšil svou sílu o " + bonusSila + "\nNový útok: " + hra.getHrac().getUtok();
        } else if (volba == 2 && robot != null && !robot.muzeMluvit()) {
            robot.opravit();
            return "\nOpravil jsi robota!";
        }

        return "\nNeplatná volba. Jádro nebylo použito.";
    }
}