/*
Resources/
    data.json -> obsahuje lokace, postavy, predmety, nepritele
    aurora.txt -> obsahuje dialog pro auroru
    poskozenyRobot.txt -> obsahuje dialog pro poškozeného Robota
    pocitac.txt -> obsahuje lore pro Pocitac Minihra
*/

package data;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

// Třída pro čtení textových souborů s dialogy
public class Cteni {

    private static BufferedReader Soubor(String postavaId) throws IOException {
        String cesta = "/" + postavaId + ".txt";
        InputStream is = Cteni.class.getResourceAsStream(cesta);

        if (is == null) {
            throw new IOException("Resource nenalezen: " + cesta);
        }

        return new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
    }

    // Načte úvodní text postavy pro lokaci
    public static String UvodniDialog(String postavaId, String lokaceId) {
        try (BufferedReader br = Soubor(postavaId)) {
            String uvod = "";
            String radek;
            boolean cteme = false;
            String klic = "UVOD_" + lokaceId + ":";

            // Hledá značku pro úvodní dialog v souboru
            while ((radek = br.readLine()) != null) {
                if (radek.equals(klic)) {
                    cteme = true;
                } else if (radek.equals("---")) {
                    // Konec bloku textu
                    if (cteme) break;
                } else {
                    // Pokud jsme v režimu čtení a řádek není jiná značka, přidáme text
                    if (cteme && !radek.startsWith("VOLBA_") && !radek.startsWith("ODPOVED_")) {
                        uvod += radek + "\n";
                    }
                }
            }

            return uvod.trim();
        } catch (IOException e) {
            return "";
        }
    }

    // Vyhledá v souboru všechny dostupné volby dialogu pro lokaci
    public static String[] DialogVolby(String postavaId, String lokaceId) {
        try (BufferedReader br = Soubor(postavaId)) {
            List<String> volby = new ArrayList<>();
            String radek;
            String id = "VOLBA_" + lokaceId + ":";

            // Vyhledá všechny řádky začínající značkou volby
            while ((radek = br.readLine()) != null) {
                if (radek.startsWith(id)) {
                    volby.add(radek.substring(id.length()).trim());
                }
            }

            // Převod seznamu na pole
            int pocet = volby.size();
            String[] vyslednePole = new String[pocet];

            for (int i = 0; i < pocet; i++) {
                vyslednePole[i] = volby.get(i);
            }
            return vyslednePole;

        } catch (IOException e) {
            return new String[]{"Chyba při čtení dialogu."};
        }
    }

    // Načte konkrétní odpověď postavy na základě zvolené možnosti
    public static String DialogOdpoved(String postavaId, String lokaceId, int cisloVolby) {
        try (BufferedReader br = Soubor(postavaId)) {
            String odpoved = "";
            String radek;
            boolean cteme = false;
            String hledany = "ODPOVED_" + lokaceId + "_" + cisloVolby + ":";

            // Hledá správnou značku odpovědi v souboru
            while ((radek = br.readLine()) != null) {
                if (radek.equals(hledany)) {
                    cteme = true;
                } else if (radek.equals("---")) {
                    // Konec bloku odpovědi
                    if (cteme) break;
                } else {
                    // Sběr textu proběhne jen pokud jsme uvnitř správného bloku
                    if (cteme && !radek.startsWith("VOLBA_") && !radek.startsWith("ODPOVED_") && !radek.startsWith("UVOD_")) {
                        odpoved += radek + "\n";
                    }
                }
            }

            return odpoved.trim();
        } catch (IOException e) {
            return "Chyba při čtení odpovědi.";
        }
    }
}