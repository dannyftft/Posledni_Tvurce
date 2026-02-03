package lokace;

import minihra.Minihra;
import minihra.Pocitac;

public class Laborator extends Lokace {
    private Minihra pc = new Pocitac();
    private boolean vyhra = false;

    public Laborator(hra.HraData.LokaceData data) {
        super(data);
    }

    @Override
    public Minihra getMinihra() { return pc; }

    @Override
    public void Vyhra() {
        this.vyhra = true;
        System.out.println("Dveře byly odemčeny.");
    }
}