/*
Resources/
    postavy.txt
    predmety.txt
    nepratel.txt
    minihry.txt
    lokace.txt
*/
//TODO VELMI DŮLEŽITÉ musím navrhnout jak se načtou data a také kolik potřebuji txt souborů (každá postava/lokace/minihra atd. dostane svůj nebo dohromady podle package ???) (Zatím podle package)



package data;

public class Cteni {

    public static String PopisPredmetu(String nazev) {
        // Načte popis předmětu z Resources/predmety.txt
        return "";
    }

    public static String PopisNepritele(String nazev) {
        // Načte popis nepřítele z Resources/nepratel.txt
        return "";
    }

    public static String PopisLokace(String nazev) {
        // Načte popis lokace z Resources/lokace.txt
        return "";
    }

    public static String PopisPostavy(String nazev) {
        // Načte popis postavy z Resources/postavy.txt
        return "";
    }

    public static String[] DialogoveVolby(String nazev) {
        // Načte dialogové možnosti pro postavu / možná každá postava dostane svůj soubor
        return new String[0];
    }

    public static String DialogovaOdpoved(String nazev, int volba) {
        // Načte odpověď postavy na dialog / možná každá postava dostane svůj soubor
        return "";
    }
}

