package predmety;

import hra.Hra;
import hra.HraData;

public class Deska extends Predmet {

    private final int leceni;

    public Deska(HraData.PredmetData data) {
        super(data);
        this.leceni = data.leceni;
    }

    @Override
    public String pouzit(Hra hra) {
        hra.getHrac().vylec(leceni);
        return "\nPoužil jsi obvodovou desku. Obnoveno " + leceni + " HP.";
    }
}