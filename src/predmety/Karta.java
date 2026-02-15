package predmety;

import hra.Hra;
import hra.HraData;

// Přístupová karta pro odemykání dveří
public class Karta extends Predmet {

    public Karta(HraData.PredmetData data) {
        super(data);
    }

    @Override
    public String pouzit(Hra hra) {
        return "\nKarta se používá automaticky při otevírání dveří.";
    }

    // Zvýší úroveň karty
    public void vylepsit() {
        uroven++;
    }
    public int getUroven() {
        return uroven;
    }
}
