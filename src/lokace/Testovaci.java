package lokace;

import hra.HraData;

public class Testovaci extends Lokace {
    public Testovaci(HraData.LokaceData data) {
        super(data.id, data.nazev, data.popis);
    }
}