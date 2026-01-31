package hra;

import hra.HraData.*;
import lokace.*;
import nepratel.Robot;
import predmety.*;
import postavy.*;
import nepratel.*;
import prikaz.konzole.Konzole;

import java.util.*;

public class Hra {
    private Hrac hrac;
    private Lokace aktualniLokace;
    private BojovyManager bojovyManager;
    private InventarSpravce inventar;
    private boolean konec;
    private HraData hraData;
    private boolean vDialogu;

    public Hra() {
        this.hrac = new Hrac();
        this.bojovyManager = new BojovyManager();
        this.inventar = new InventarSpravce();
        this.konec = false;
        this.vDialogu = false;
    }

    public void start() {
        vytvorMapu();
        Konzole konzole = new Konzole(this);
        konzole.start();
        System.out.println(aktualniLokace.getPopis());
    }

    public void vytvorMapu() {
        hraData = HraData.nactiHerniData("/data.json");

        // Nastaví statistiky hráče
        hrac.setMaxZdravi(hraData.hrac.max_zdravi);
        hrac.setZdravi(hraData.hrac.max_zdravi);
        hrac.setUtok(hraData.hrac.utok);

        // Vytvoří seznam všech místností aby se k nim dalo snadno přistupovat přes ID
        Map<String, Lokace> lokaceMap = new HashMap<>();
        for (LokaceData data : hraData.lokace) {
            Lokace lokace = vytvorLokaci(data.id);
            lokaceMap.put(data.id, lokace);
        }

        // Propojí lokace
        propojLokace(lokaceMap);

        // Naplňí lokace
        naplnLokace(lokaceMap);

        // Nastaví počáteční lokaci
        aktualniLokace = lokaceMap.get("zacatecni");
    }

    private Lokace vytvorLokaci(String id) {
        LokaceData data = hraData.najdiLokaci(id);

        switch (id) {
            case "zacatecni": return new Zacatecni(data);
            case "chodba": return new Chodba(data);
            case "laborator": return new Laborator(data);
            case "servis": return new Servis(data);
            case "jidelna": return new Jidelna(data);
            case "obytnyProstor": return new ObytnyProstor(data);
            case "testovaci": return new Testovaci(data);
            case "ridici": return new Ridici(data);
            default:
                throw new IllegalArgumentException("Neznámá lokace: " + id);
        }
    }

    // Projde všechny místnosti a vytvoří mezi nimi průchody podle toho co je v souboru
    private void propojLokace(Map<String, Lokace> lokaceMap) {
        for (LokaceData data : hraData.lokace) {
            Lokace aktualni = lokaceMap.get(data.id);

            // Pokud má místnost v datech nastavený další propojí je
            if (data.dalsi != null) {
                Lokace dalsi = lokaceMap.get(data.dalsi);
                if (dalsi != null) {
                    aktualni.pridejPropojeni(dalsi);
                }
            }

            // Pokud se dá z místnosti vracet vytvoří cestu zpět
            if (data.muzuZpet && data.predchozi != null) {
                Lokace predchozi = lokaceMap.get(data.predchozi);
                if (predchozi != null) {
                    aktualni.pridejPropojeni(predchozi);
                }
            }
        }
    }

    // Projde každou místnost a vloží do ní vše co tam podle souboru patří
    private void naplnLokace(Map<String, Lokace> lokaceMap) {
        for (LokaceData lokaceData : hraData.lokace) {
            Lokace lokace = lokaceMap.get(lokaceData.id);

            // Výrtvoření a vložení předmětů
            if (lokaceData.predmety != null) {
                for (String predmetId : lokaceData.predmety) {
                    Predmet predmet = vytvorPredmet(predmetId);
                    if (predmet != null) {
                        lokace.pridejPredmet(predmet);
                    }
                }
            }

            // Vytovření a vložení postav
            if (lokaceData.postavy != null) {
                for (String postavaId : lokaceData.postavy) {
                    Postava postava = vytvorPostavu(postavaId);
                    if (postava != null) {
                        lokace.pridejPostavu(postava);
                    }
                }
            }

            // Vytvoření a vložení nepřátel
            if (lokaceData.nepratelove != null) {
                for (String nepritelId : lokaceData.nepratelove) {
                    Nepritel nepritel = vytvorNepritele(nepritelId);
                    if (nepritel != null) {
                        lokace.pridejNepritele(nepritel);
                    }
                }
            }
        }
    }

    // Vytvoří instanci předmětu
    private Predmet vytvorPredmet(String id) {
        PredmetData data = hraData.najdiPredmet(id);
        if (data == null) return null; // Pokud data v JSON nejsou

        switch (id) {
            case "deska": return new Deska(data);
            case "jadro": return new Jadro(data);
            case "kamen": return new Kamen(data);
            case "karta": return new Karta(data);
            case "trubka": return new Trubka(data);
            default: return null; // Není třída
        }
    }

    // Vytvoří instanci postavy
    private Postava vytvorPostavu(String id) {
        PostavaData data = hraData.najdiPostavu(id);
        if (data == null) return null; // Pokud data v JSON nejsou


        switch (id) {
            case "aurora": return new Aurora(data);
            case "poskozenyRobot": return new PoskozenyRobot(data);
            default: return null; // Není třída
        }
    }

    // Vytvoří instanci nepřítele
    private Nepritel vytvorNepritele(String id) {
        NepritelData data = hraData.najdiNepritele(id);
        if (data == null) return null; // Pokud data v JSON nejsou

        switch (id) {
            case "robot": return new Robot(data);
            case "dron": return new Dron(data);
            case "mech": return new Mech(data);
            default: return null; // Není třída
        }
    }

    public void ZmenaLokace(Lokace novaLokace) {
        this.aktualniLokace = novaLokace;
    }

    public void setAktualniLokace(Lokace lokace) {
        this.aktualniLokace = lokace;
    }

    public void setKonec(boolean konec) {
        this.konec = konec;
    }

    public boolean jeVDialogu() {
        return vDialogu;
    }

    public void setVDialogu(boolean stav) {
        this.vDialogu = stav;
    }

    public Hrac getHrac() { return hrac; }
    public Lokace getAktualniLokace() { return aktualniLokace; }
    public BojovyManager getBojovyManager() { return bojovyManager; }
    public InventarSpravce getInventar() { return inventar; }
    public boolean jeKonec() { return konec; }
}