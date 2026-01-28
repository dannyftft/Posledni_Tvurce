package hra;

import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class HraData {

    public HracData hrac;
    public ArrayList<LokaceData> lokace;
    public ArrayList<PredmetData> predmety;
    public ArrayList<PostavaData> postavy;
    public ArrayList<NepritelData> nepratelove;


    public static HraData nactiHerniData(String resourcePath) {
        Gson gson = new Gson();

        try (InputStream is = HraData.class.getResourceAsStream(resourcePath)) {
            if (is == null) {
                throw new IllegalStateException("Nenalezen resource: " + resourcePath +
                        " (zkontrolujte, že soubor je v Resources).");
            }

            return gson.fromJson(
                    new InputStreamReader(is, StandardCharsets.UTF_8),
                    HraData.class
            );

        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }
    }

    public LokaceData najdiLokaci(String id) {
        for (LokaceData l : lokace) {
            if (l.id.equals(id)) {
                return l;
            }
        }
        throw new IllegalArgumentException("Neexistuje lokace s id: " + id);
    }

    public PredmetData najdiPredmet(String id) {
        for (PredmetData p : predmety) {
            if (p.id.equals(id)) {
                return p;
            }
        }
        return null;
    }

    public PostavaData najdiPostavu(String id) {
        for (PostavaData p : postavy) {
            if (p.id.equals(id)) {
                return p;
            }
        }
        return null;
    }

    public NepritelData najdiNepritele(String id) {
        for (NepritelData n : nepratelove) {
            if (n.id.equals(id)) {
                return n;
            }
        }
        return null;
    }

    public static class HracData {
        public int max_zdravi;
        public int sila;
        public int utok;
    }

    public static class LokaceData {
        public String id;
        public String nazev;
        public String popis;
        public String dalsi;
        public String predchozi;
        public boolean muzuZpet;
        public boolean zamcena;
        public int pozadovana_uroven_karty;
        public ArrayList<String> predmety;
        public ArrayList<String> nepratelove;
        public ArrayList<String> postavy;
    }

    public static class PredmetData {
        public String id;
        public String nazev;
        public String popis;
        public Integer leceni;
        public Integer bonus_sila;
        public Integer poskozeni;
        public Integer uroven;
        public boolean spotrebovatelny;
        public boolean zabira_slot;
    }

    public static class PostavaData {
        public String id;
        public String nazev;
        public String popis;
        public Boolean opraven;
        public Boolean aktivni;
    }

    public static class NepritelData {
        public String id;
        public String nazev;
        public String popis;
        public int utok;
        public int zdravi;
    }
}