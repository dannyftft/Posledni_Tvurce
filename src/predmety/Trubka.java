package predmety;

import hra.Hra;
import hra.HraData;

public class Trubka extends Predmet {

    private final int bonusSila;

    public Trubka(HraData.PredmetData data) {
        super(data);
        this.bonusSila = data.bonus_sila;
    }

    @Override
    public String pouzit(Hra hra) {
        return "Trubka se používá automaticky v boji.";
    }

    public int getBonusSila() {
        return bonusSila;
    }
}
