package hra;

public class Hrac {

    private int zdravi;
    private int maxZdravi;
    private int sila;
    private int utok;

    public void zran(int hodnota) {
        this.zdravi -= hodnota;
        if (this.zdravi < 0) {
            this.zdravi = 0;
        }
    }

    public void vylec(int hodnota) {
        this.zdravi += hodnota;
        if (this.zdravi > maxZdravi) {
            this.zdravi = maxZdravi;
        }
    }

    public void zvysSilu(int hodnota) {
        this.sila += hodnota;
        this.utok += hodnota;
    }

    public boolean jeNazivu() {
        return zdravi > 0;
    }

    public int getUtok() {
        return utok;
    }

    public int getZdravi() {
        return zdravi;
    }

    public int getMaxZdravi() {
        return maxZdravi;
    }

    public int getSila() {
        return sila;
    }

    public void setZdravi(int zdravi) {
        this.zdravi = zdravi;
    }

    public void setMaxZdravi(int maxZdravi) {
        this.maxZdravi = maxZdravi;
    }

    public void setSila(int sila) {
        this.sila = sila;
    }

    public void setUtok(int utok) {
        this.utok = utok;
    }
}