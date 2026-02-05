package lokace;

import minihra.Logicka;
import minihra.Minihra;

public class Jidelna extends Lokace {
    private Minihra logicka = new Logicka();

    public Jidelna(hra.HraData.LokaceData data) {
        super(data);
    }

    @Override
    public Minihra getMinihra() {
        return logicka;
    }
}
