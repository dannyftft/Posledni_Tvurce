package predmety;

import hra.Hra;
import hra.HraData;

// Obvodová deska pro léčení hráče
public class Deska extends Predmet {

    private final int leceni;

    public Deska(HraData.PredmetData data) {
        super(data);
        this.leceni = data.leceni;
    }

    // Použije desku a vyléčí hráče
    @Override
    public String pouzit(Hra hra) {
        hra.getHrac().vylec(leceni);
        return "\nPoužil jsi obvodovou desku. Obnoveno " + leceni + " HP.";
    }
}