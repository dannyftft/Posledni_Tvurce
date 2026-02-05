package nepratel;

import hra.HraData;

public abstract class Nepritel {
    protected String id;
    protected String nazev;
    protected String popis;
    protected int zdravi;
    protected int utok;

    public Nepritel(HraData.NepritelData data) {
        this.id = data.id;
        this.nazev = data.nazev;
        this.zdravi = data.zdravi;
        this.utok = data.utok;
        this.popis = data.popis;
    }

    public void poskozeni(int poskozeni) {
        this.zdravi -= poskozeni;
        if (this.zdravi < 0) {
            this.zdravi = 0;
        }
    }

    public boolean jePorazen() {
        return zdravi <= 0;
    }

    public String zobrazStav() {
        return nazev + " - Zdraví: " + zdravi;
    }

    public int getUtok() {
        return utok;
    }

    public int getZdravi() {
        return zdravi;
    }

    public String getNazev() {
        return nazev;
    }

    public String getId() {
        return id;
    }
}