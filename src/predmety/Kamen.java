package predmety;

import hra.Hra;
import hra.HraData;

public class Kamen extends Predmet {

    private final int poskozeni;

    public Kamen(HraData.PredmetData data) {
        super(data);
        this.poskozeni = data.poskozeni;
    }

    @Override
    public String pouzit(Hra hra) {
        return "Kámen lze použít pouze v boji.";
    }

    public int getPoskozeni() {
        return poskozeni;
    }
}
