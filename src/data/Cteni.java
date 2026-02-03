/*
Resources/
    data.json -> obsahuje lokace, postavy, predmety, nepritele
    aurora.txt -> obsahuje dailog pro auroru
    poskozenyRobot.txt -> obsahuje dialog pro poškozeného Robota
*/

package data;

import java.io.*;
import java.util.*;

public class Cteni {


    // Načte úvodní text postavy pro lokaci
    public static String nactiUvodniDialog(String postavaId, String lokaceId) {
        String soubor = "Resources/" + postavaId + ".txt";

        // Uzavře BufferedReader po skončení bloku
        try (BufferedReader br = new BufferedReader(new FileReader(soubor))) {
            String uvod = "";
            String radek;
            boolean cteme = false;
            String klic = "UVOD_" + lokaceId + ":";

            // Čtení souboru řádek po řádku
            while ((radek = br.readLine()) != null) {
                // Pokud narazí na značku úvodu pro lokaci začne ukládat text
                if (radek.equals(klic)) {
                    cteme = true;
                    continue;
                }

                // Značka '---' ukončuje aktuální blok textu
                if (radek.equals("---")) {
                    if (cteme) break;
                }

                // Pokud uvnitř bloku není jiný příkaz přidá řádek do výsledku
                if (cteme && !radek.startsWith("VOLBA_") && !radek.startsWith("ODPOVED_")) {
                    uvod += radek + "\n";
                }
            }

            return uvod.trim();
        } catch (IOException e) {
            return "";
        }
    }

    // Vyhledá v souboru všechny dostupné volby dialogu pro lokaci
    public static String[] nactiDialogVolby(String postavaId, String lokaceId) {
        String soubor = "Resources/" + postavaId + ".txt";

        try (BufferedReader br = new BufferedReader(new FileReader(soubor))) {
            List<String> volby = new ArrayList<>();
            String radek;
            String id = "VOLBA_" + lokaceId + ":";

            while ((radek = br.readLine()) != null) {
                // Hledá řádky které začínají klíčem pro volbu (např. VOLBA_LOKACE1:)
                if (radek.startsWith(id)) {
                    // Uloží pouze samotný text volby
                    volby.add(radek.substring(id.length()).trim());
                }
            }

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
    public static String nactiDialogOdpoved(String postavaId, String lokaceId, int cisloVolby) {
        String soubor = "Resources/" + postavaId + ".txt";

        try (BufferedReader br = new BufferedReader(new FileReader(soubor))) {
            String odpoved = "";
            String radek;
            boolean cteme = false;
            // Sestaví klíč např. ODPOVED_LOKACE1_1:
            String hledany = "ODPOVED_" + lokaceId + "_" + cisloVolby + ":";

            while ((radek = br.readLine()) != null) {
                // Najde začátek bloku pro konkrétní odpověď
                if (radek.equals(hledany)) {
                    cteme = true;
                    continue;
                }

                // Konec bloku při narazení na oddělovač
                if (radek.equals("---")) {
                    if (cteme) {
                        break;
                    }
                }

                // Ignoruje ostatní značky a sbírá pouze text odpovědi
                if (cteme && !radek.startsWith("VOLBA_") && !radek.startsWith("ODPOVED_") && !radek.startsWith("UVOD_")) {
                    odpoved += radek + "\n";
                }
            }

            return odpoved.trim();
        } catch (IOException e) {
            return "Chyba při čtení odpovědi.";
        }
    }
}