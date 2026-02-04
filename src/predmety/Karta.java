package predmety;

import hra.Hra;
import hra.HraData;

public class Karta extends Predmet {

    public Karta(HraData.PredmetData data) {
        super(data);
    }

    @Override
    public String pouzit(Hra hra) {
        return "Karta se používá automaticky při otevírání dveří.";
    }

    public void vylepsit() {
        uroven++;
    }
    public int getUroven() {
        return uroven;
    }
}
