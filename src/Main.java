import hra.Hra;
import hra.HraData;
import hra.HraData.LokaceData;

public class Main {
    public static void main(String[] args) {
        HraData data = HraData.nactiHerniData("/data.json");

        //Načítání
        System.out.println("Lokace: " + data.lokace.size());
        System.out.println("Predmety: " + data.predmety.size());
        System.out.println("Postavy: " + data.postavy.size());
        System.out.println("Nepratelove: " + data.nepratelove.size());

        //Pohyb
        LokaceData lok = data.najdiLokaci("zacatecni");
        System.out.println("Start: " + lok.nazev);

        lok = jdi(data, lok, lok.dalsi);
        System.out.println("Dalsi: " + lok.nazev);

        lok = jdi(data, lok, lok.predchozi);
        System.out.println("Zpet: " + lok.nazev);

        lok = jdi(data, lok, null);
        System.out.println("Nikam: " + lok.nazev);

        //Test hry
        Hra hra = new Hra();
        hra.start();
        System.out.println("Hrac zdravi: " + hra.getHrac().getZdravi());
    }

    private static LokaceData jdi(HraData data, LokaceData lok, String id) {
        if (id == null) {
            System.out.println("Nelze jit");
            return lok;
        }
        return data.najdiLokaci(id);
    }
}