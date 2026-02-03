package predmety;

import hra.Hra;
import hra.HraData;
import postavy.PoskozenyRobot;
import postavy.Postava;
import java.util.Scanner;

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

        System.out.print("\n>> ");
        int volba = scanner.nextInt();
        scanner.nextLine();

        if (volba == 1) {
            hra.getHrac().zvysSilu(bonusSila);
            return "Použil jsi energetické jádro a zvýšil svou sílu o " + bonusSila + "\nNový útok: " + hra.getHrac().getUtok();
        } else if (volba == 2 && robot != null && !robot.muzeMluvit()) {
            robot.opravit();
            return "Opravil jsi robota!";
        }

        return "Neplatná volba. Jádro nebylo použito.";
    }
}