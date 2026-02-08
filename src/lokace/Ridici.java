package lokace;

import minihra.Deaktivace;
import minihra.Minihra;
import hra.Hra;

public class Ridici extends Lokace {
    private Hra hra;
    private Minihra deaktivace;

    public Ridici(hra.HraData.LokaceData data, Hra hra) {
        super(data);
        this.hra = hra;
        this.deaktivace = new Deaktivace(hra);
    }

    @Override
    public Minihra getMinihra() {
        return deaktivace;
    }
}