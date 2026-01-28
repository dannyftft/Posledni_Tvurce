package lokace;

import hra.HraData;

public class Servis extends Lokace {
    public Servis(HraData.LokaceData data) {
        super(data.id, data.nazev, data.popis);
    }
}