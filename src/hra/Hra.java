package hra;

import hra.HraData.*;
import lokace.*;
import nepratel.Robot;
import predmety.*;
import postavy.*;
import nepratel.*;
import prikaz.konzole.Konzole;

import java.awt.*;
import java.util.*;

public class Hra {
    private Hrac hrac;
    private Lokace aktualniLokace;
    private BojovyManager bojovyManager;
    private InventarSpravce inventar;
    private boolean konec;
    private HraData hraData;

    public Hra() {
        this.hrac = new Hrac();
        this.bojovyManager = new BojovyManager();
        this.inventar = new InventarSpravce();
        this.konec = false;
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

        // Vytvoří všechny lokace
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

        Lokace lokace;
        switch (id) {
            case "zacatecni": lokace = new Zacatecni(data); break;
            case "chodba": lokace = new Chodba(data); break;
            case "laborator": lokace = new Laborator(data); break;
            case "servis": lokace = new Servis(data); break;
            case "jidelna": lokace = new Jidelna(data); break;
            case "obytnyProstor": lokace = new ObytnyProstor(data); break;
            case "testovaci": lokace = new Testovaci(data); break;
            case "ridici": lokace = new Ridici(data); break;
            default:
                throw new IllegalArgumentException("Neznámá lokace: " + id);
        }

        lokace.nastavPopis(data.popis);
        return lokace;
    }

    private void propojLokace(Map<String, Lokace> lokaceMap) {
        for (LokaceData data : hraData.lokace) {
            Lokace aktualni = lokaceMap.get(data.id);

            if (data.dalsi != null) {
                Lokace dalsi = lokaceMap.get(data.dalsi);
                if (dalsi != null) {
                    aktualni.pridejPropojeni(dalsi);
                }
            }

            if (data.muzuZpet && data.predchozi != null) {
                Lokace predchozi = lokaceMap.get(data.predchozi);
                if (predchozi != null) {
                    aktualni.pridejPropojeni(predchozi);
                }
            }
        }
    }

    private void naplnLokace(Map<String, Lokace> lokaceMap) {
        for (LokaceData lokaceData : hraData.lokace) {
            Lokace lokace = lokaceMap.get(lokaceData.id);

            if (lokaceData.predmety != null) {
                for (String predmetId : lokaceData.predmety) {
                    Predmet predmet = vytvorPredmet(predmetId);
                    if (predmet != null) {
                        lokace.pridejPredmet(predmet);
                    }
                }
            }

            if (lokaceData.postavy != null) {
                for (String postavaId : lokaceData.postavy) {
                    Postava postava = vytvorPostavu(postavaId);
                    if (postava != null) {
                        lokace.pridejPostavu(postava);
                    }
                }
            }

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

    private Predmet vytvorPredmet(String id) {
        PredmetData data = hraData.najdiPredmet(id);
        if (data == null) return null;

        Predmet p = null;
        switch (id) {
            case "deska": p = new Deska(data.id, data.nazev, data.leceni); break;
            case "jadro": p = new Jadro(data.id, data.nazev, data.bonus_sila); break;
            case "kamen": p = new Kamen(data.id, data.nazev, data.poskozeni); break;
            case "karta": p = new Karta(data.id, data.nazev); break;
            case "trubka": p = new Trubka(data.id, data.nazev, data.bonus_sila); break;
        }

        if (p != null) {
            p.nastavPopis(data.popis);
        }
        return p;
    }

    private Postava vytvorPostavu(String id) {
        PostavaData data = hraData.najdiPostavu(id);
        if (data == null) return null;

        switch (id) {
            case "aurora": return new Aurora();
            case "poskozenyRobot": return new PoskozenyRobot();
            default: return null;
        }
    }

    private Nepritel vytvorNepritele(String id) {
        NepritelData data = hraData.najdiNepritele(id);
        if (data == null) return null;

        Nepritel n = null;
        switch (id) {
            case "robot": n = new Robot(data.id, data.nazev, data.zdravi, data.utok); break;
            case "dron": n = new Dron(data.id, data.nazev, data.zdravi, data.utok); break;
            case "mech": n = new Mech(data.id, data.nazev, data.zdravi, data.utok); break;
        }

        if (n != null) {
            n.setPopis(data.popis);
        }
        return n;
    }

    public void ZmenaLokace(Lokace novaLokace) {
        this.aktualniLokace = novaLokace;
        System.out.println("\n" + novaLokace.getPopis());
    }

    public void setAktualniLokace(Lokace lokace) {
        this.aktualniLokace = lokace;
    }

    public void setKonec(boolean konec) {
        this.konec = konec;
    }

    public Hrac getHrac() { return hrac; }
    public Lokace getAktualniLokace() { return aktualniLokace; }
    public BojovyManager getBojovyManager() { return bojovyManager; }
    public InventarSpravce getInventar() { return inventar; }
    public boolean jeKonec() { return konec; }
}