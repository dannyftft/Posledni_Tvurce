package lokace;

import hra.HraData;

public class Zacatecni extends Lokace {
    public Zacatecni(HraData.LokaceData data) {
        super(data.id, data.nazev, data.popis);
    }
}