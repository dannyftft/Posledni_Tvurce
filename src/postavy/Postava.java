package postavy;

import hra.HraData;

public abstract class Postava {
    protected String id;
    protected String nazev;
    protected String popis;;
    protected boolean aktivni;

    public Postava(HraData.PostavaData data) {
        this.id = data.id;
        this.nazev = data.nazev;
        this.popis = data.popis;
        this.aktivni = data.aktivni;
    }

    public abstract String[] getDialogVolby();

    public abstract String getDialogOdpoved(int cisloVolby);

    public abstract boolean muzeMluvit();

    public String getJmeno() {
        return this.nazev;
    }

    public String getPopis() {
        return this.popis;
    }

    public void nastavPopis(String popis) {
        this.popis = popis;
    }

    public String getId() {
        return this.id;
    }

    public String getUvodniDialog(String lokaceId) {
        return "";
    }

    public void nastavLokaci(String lokaceId) {
    }
}