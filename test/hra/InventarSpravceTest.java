package hra;

import org.junit.jupiter.api.Test;
import predmety.Kamen;
import predmety.Karta;

import static org.junit.jupiter.api.Assertions.*;

class InventarSpravceTest {

    // Ověří že plný inventář odmítne přidat čtvrtý předmět
    @Test
    void pridejPredmet() {
        InventarSpravce inventar = new InventarSpravce();

        HraData.PredmetData data1 = new HraData.PredmetData();
        data1.id = "kamen";
        data1.nazev = "Kámen";
        data1.zabira_slot = true;
        data1.poskozeni = 5;
        HraData.PredmetData data2 = new HraData.PredmetData();
        data2.id = "kamen2";
        data2.nazev = "Kámen 2";
        data2.zabira_slot = true;
        data2.poskozeni = 5;
        HraData.PredmetData data3 = new HraData.PredmetData();
        data3.id = "kamen3";
        data3.nazev = "Kámen 3";
        data3.zabira_slot = true;
        data3.poskozeni = 5;
        HraData.PredmetData data4 = new HraData.PredmetData();
        data4.id = "kamen4";
        data4.nazev = "Kámen 4";
        data4.zabira_slot = true;
        data4.poskozeni = 5;

        inventar.pridejPredmet(new Kamen(data1));
        inventar.pridejPredmet(new Kamen(data2));
        inventar.pridejPredmet(new Kamen(data3));

        assertFalse(inventar.pridejPredmet(new Kamen(data4)));
        assertFalse(inventar.jeVolnySlot());
    }

    // Ověří že vylepšení karty zvýší její úroveň o 1
    @Test
    void vylepsiKartu() {
        InventarSpravce inventar = new InventarSpravce();

        HraData.PredmetData data = new HraData.PredmetData();
        data.id = "karta";
        data.nazev = "Přístupová karta";
        data.zabira_slot = false;
        data.uroven = 1;

        inventar.pridejPredmet(new Karta(data));
        inventar.vylepsiKartu();

        assertEquals(2, inventar.getKarta().getUroven());
    }
}