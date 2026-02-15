package predmety;

import hra.Hra;
import hra.HraData;

// Kovová trubka je zbraň na blízko
public class Trubka extends Predmet {

    private final int bonusSila;

    public Trubka(HraData.PredmetData data) {
        super(data);
        this.bonusSila = data.bonus_sila;
    }

    @Override
    public String pouzit(Hra hra) {
        return "\nTrubka se používá automaticky v boji.";
    }

    // Vrátí bonus k síle při použití trubky
    public int getBonusSila() {
        return bonusSila;
    }
}
