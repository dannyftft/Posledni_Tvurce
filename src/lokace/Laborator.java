package lokace;

import hra.HraData;

public class Laborator extends Lokace {
    public Laborator(HraData.LokaceData data) {
        super(data.id, data.nazev, data.popis);
    }
}