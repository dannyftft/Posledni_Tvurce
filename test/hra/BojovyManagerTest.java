package hra;

import nepratel.Robot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BojovyManagerTest {

    // Ověří že útok hráče způsobí správné poškození nepříteli
    @Test
    void utokHrace() {
        Hrac hrac = new Hrac();
        hrac.setMaxZdravi(100);
        hrac.setZdravi(100);
        hrac.setUtok(15);

        HraData.NepritelData nepritelData = new HraData.NepritelData();
        nepritelData.id = "robot";
        nepritelData.nazev = "Robot";
        nepritelData.zdravi = 50;
        nepritelData.utok = 5;
        Robot robot = new Robot(nepritelData);

        InventarSpravce inventar = new InventarSpravce();
        BojovyManager bm = new BojovyManager();
        bm.ZacniSouboj(hrac, robot, inventar);

        bm.UtokHrace(0);

        assertEquals(35, robot.getZdravi());
    }

    // Ověří že útok nepřítele správně sníží zdraví hráče
    @Test
    void utokNepritele() {
        Hrac hrac = new Hrac();
        hrac.setMaxZdravi(100);
        hrac.setZdravi(100);
        hrac.setUtok(10);

        HraData.NepritelData nepritelData = new HraData.NepritelData();
        nepritelData.id = "robot";
        nepritelData.nazev = "Robot";
        nepritelData.zdravi = 200;
        nepritelData.utok = 20;
        Robot robot = new Robot(nepritelData);

        InventarSpravce inventar = new InventarSpravce();
        BojovyManager bm = new BojovyManager();
        bm.ZacniSouboj(hrac, robot, inventar);

        bm.UtokNepritele();

        assertEquals(80, hrac.getZdravi());
    }
}