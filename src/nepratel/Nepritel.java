package nepratel;

public abstract class Nepritel {
    protected String id;
    protected String nazev;
    protected String popis;
    protected int zdravi;
    protected int utok;

    public Nepritel(String id, String nazev, int zdravi, int utok) {
        this.id = id;
        this.nazev = nazev;
        this.zdravi = zdravi;
        this.utok = utok;
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

    public String getPopis() {
        return popis;
    }
    public String getId() {
        return id;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }
}