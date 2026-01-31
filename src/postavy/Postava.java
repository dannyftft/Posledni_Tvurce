package postavy;

import hra.HraData;

public abstract class Postava {
    protected String id;
    protected String nazev;
    protected String popis;
    protected boolean opraven;
    protected boolean aktivni;

    public Postava(HraData.PostavaData data) {
        this.id = data.id;
        this.nazev = data.nazev;
        this.popis = data.popis;
        if (data.opraven != null) {
            this.opraven = data.opraven;
        } else {
            this.opraven = false;
        }
        if (data.aktivni != null) {
            this.aktivni = data.aktivni;
        } else {
            this.aktivni = false;
        }
    }

    public abstract String[] getDialogVolby(String lokace);

    public abstract String getDialogOdpoved(String lokace, int cisloVolby);

    public abstract String getUvodniDialog(String lokace);

    public abstract boolean muzeMluvit();

    public String getJmeno() {
        return this.nazev;
    }

    public String getPopis() {
        return this.popis;
    }

    public String getId() {
        return this.id;
    }
}