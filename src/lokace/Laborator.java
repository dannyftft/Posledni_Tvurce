package lokace;

import minihra.Minihra;
import minihra.Pocitac;

public class Laborator extends Lokace {
    private Minihra pc = new Pocitac();

    public Laborator(hra.HraData.LokaceData data) {
        super(data);
    }

    @Override
    public Minihra getMinihra() {
        return pc;
    }

    @Override
    public void Vyhra() {
        Lokace dalsi =getSousedniLokace().getFirst();
        if (dalsi != null) {
            dalsi.setZamcena(false);
        }
        System.out.println("Dveře do další místnosti byly odemčeny.");
    }
}
