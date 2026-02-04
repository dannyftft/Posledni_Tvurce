package lokace;

import hra.HraData;
import minihra.Minihra;
import predmety.Predmet;
import postavy.Postava;
import nepratel.Nepritel;
import java.util.ArrayList;
import java.util.List;

public abstract class Lokace {
    protected String id;
    protected String nazev;
    protected String popis;
    protected List<Lokace> sousedniLokace;
    protected List<Predmet> predmety;
    protected List<Postava> postavy;
    protected ArrayList<Nepritel> nepratelove;
    protected boolean zamcena;
    protected int pozadovanaUrovenKarty;

    public Lokace(HraData.LokaceData data) {
        this.id = data.id;
        this.nazev = data.nazev;
        this.popis = data.popis;
        this.zamcena = data.zamcena;
        this.pozadovanaUrovenKarty = data.pozadovana_uroven_karty;
        this.sousedniLokace = new ArrayList<>();
        this.predmety = new ArrayList<>();
        this.postavy = new ArrayList<>();
        this.nepratelove = new ArrayList<>();
        }

    public void pridejPropojeni(Lokace lokace) {
        if (!sousedniLokace.contains(lokace)) {
            sousedniLokace.add(lokace);
        }
    }

    public void pridejPredmet(Predmet predmet) {
        predmety.add(predmet);
    }

    public void pridejPostavu(Postava postava) {
        postavy.add(postava);
    }

    public void pridejNepritele(Nepritel nepritel) {
        nepratelove.add(nepritel);
    }

    public List<Lokace> getSousedniLokace() {
        return sousedniLokace;
    }

    public boolean jeZamcena(){
        return zamcena;
    }

    public String getPopis() {
        // Vrátí popis lokace
        return popis;
    }

    public List<Predmet> getPredmety() {
        return predmety;
    }

    public List<Postava> getPostavy() {
        return postavy;
    }

    public ArrayList<Nepritel> getNepratelove() {
        return nepratelove;
    }

    public String getId() {
        return id;
    }

    public String getNazev() {
        return nazev;
    }

    public Minihra getMinihra() {
        return null;
    }

    public int getPozadovanaUrovenKarty() {
        return pozadovanaUrovenKarty;
    }

    public void setZamcena(boolean zamcena){
        this.zamcena = zamcena;
    }

    public void Vyhra(){
    }
}