package lokace;

import hra.HraData;

public class Ridici extends Lokace {
    public Ridici(HraData.LokaceData data) {
        super(data.id, data.nazev, data.popis);
    }
}