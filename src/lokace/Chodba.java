package lokace;

import hra.HraData;

public class Chodba extends Lokace {
    public Chodba(HraData.LokaceData data) {
        super(data.id, data.nazev, data.popis);
    }
}