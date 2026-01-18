package lokace;

import predmety.Predmet;
import postavy.Postava;
import nepratel.Nepritel;
import data.Cteni;
import java.util.ArrayList;
import java.util.List;

public abstract class Lokace {
    protected String id;
    protected String nazev;
    protected String popis;
    protected List<Lokace> sousedniLokace;
    protected List<Predmet> predmety;
    protected List<Postava> postavy;
    protected List<Nepritel> nepratelove;
    protected boolean zamcena;
    protected int pozadovanaUrovenKarty;

    public Lokace(String id) {
        this.id = id;
        this.sousedniLokace = new ArrayList<>();
        this.predmety = new ArrayList<>();
        this.postavy = new ArrayList<>();
        this.nepratelove = new ArrayList<>();
        this.popis = Cteni.PopisLokace(id);
    }

    public void pridejPropojeni(Lokace lokace) {
        // Přidá sousední lokaci
    }

    public String getPopis() {
        // Vrátí popis lokace
        return popis;
    }

    public String[] getSeznamSousedu() {
        return new String[0];
    }

    public void pridejPredmet(Predmet predmet) {
        // Přidá předmět do lokace
    }

    public Predmet odeberPredmet(String nazev) {
        // Pokud jde odebere a vrátí předmět
        return null;
    }

    public List<Predmet> getPredmety() {
        return predmety;
    }

    public void pridejPostavu(Postava postava) {
    }


    public List<Postava> getPostavy() {
        return postavy;
    }

    public void pridejNepritele(Nepritel nepritel) {
    }

    public List<Nepritel> getNepratelove() {
        return nepratelove;
    }

    public boolean jePristupna(int urovenKarty) {
        return false;
    }

    public boolean jeZamcena() {
        return zamcena;
    }

    public String getId() {
        return id;
    }

    public String getNazev() {
        return nazev;
    }
}