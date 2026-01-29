package predmety;

import hra.Hra;
import hra.HraData;

public abstract class Predmet {

    protected String id;
    protected String nazev;
    protected String popis;
    protected boolean spotrebovatelny;
    protected boolean zabiraSlot;
    protected Integer uroven;

    public Predmet(HraData.PredmetData data) {
        this.id = data.id;
        this.nazev = data.nazev;
        this.popis = data.popis;
        this.spotrebovatelny = data.spotrebovatelny;
        this.zabiraSlot = data.zabira_slot;
        this.uroven = data.uroven;
    }

    public abstract String pouzit(Hra hra);

    public boolean jeSpotrebovatelny() {
        return spotrebovatelny;
    }

    public boolean zabiraSlot() {
        return zabiraSlot;
    }

    public String getNazev() {
        return nazev;
    }

    public String getPopis() {
        return popis;
    }

    public Integer getUroven() {
        return uroven;
    }

    public void setUroven(Integer uroven) {
        this.uroven = uroven;
    }

    public void nastavPopis(String popis) {
        this.popis = popis;
    }

    public String getId() {
        return id;
    }
}