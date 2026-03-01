package predmety;

import hra.Hra;
import hra.HraData;

// Kámen jako vrhací zbraň
public class Kamen extends Predmet {

    private final int poskozeni;

    public Kamen(HraData.PredmetData data) {
        super(data);
        this.poskozeni = data.poskozeni;
    }

    @Override
    public String pouzit(Hra hra) {
        return "\nKámen lze použít pouze v boji.";
    }

    // Vrátí hodnotu poškození kamene
    public int getPoskozeni() {
        return poskozeni;
    }
}
