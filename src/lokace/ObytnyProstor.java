package lokace;

import predmety.Karta;

public class ObytnyProstor extends Lokace {
    public ObytnyProstor() {
        super("obytnyProstor");
    }

    public void vylepsitKartu(Karta karta){
        karta.vylepsit();
    }
}