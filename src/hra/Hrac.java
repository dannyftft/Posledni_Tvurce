package hra;

public class Hrac {

    private int zdravi;
    private int maxZdravi;
    private int sila;
    private int utok;

    public void zran(int hodnota) {
        // Sníží zdraví hráče
    }

    public void vylec(int hodnota) {
        // Zvýší zdraví hráče, max do maxZdravi
    }

    public void zvysSilu(int hodnota) {
        // Trvale zvýší sílu hráče
    }

    public boolean jeNazivu() {
        // Vrátí true pokud má hráč více než 0 zdraví
        return false;
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
}
