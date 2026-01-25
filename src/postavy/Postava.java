package postavy;


public abstract class Postava {
    protected String jmeno;
    protected String popis;

    public Postava(String jmeno) {
        this.jmeno = jmeno;
        nactiPopis();
    }

    protected void nactiPopis() {
        // this.popis = načtené ze souboru
    }

    public abstract String[] getDialogVolby();

    public abstract String getDialogOdpoved(int cisloVolby);

    public abstract boolean muzeMluvit();
    // Vrátí pokud s postavou lze ted mluvit

    public String getJmeno() {
        return this.jmeno;
    }

    public String getPopis() {
        //vrátí načtený popis
        return this.popis;
    }
}