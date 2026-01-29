package lokace;

import hra.HraData;
import predmety.Karta;

public class ObytnyProstor extends Lokace {
    public ObytnyProstor(HraData.LokaceData data) {
        super(data);
    }
    public void vylepsitKartu(Karta karta){
        karta.vylepsit();
    }
}