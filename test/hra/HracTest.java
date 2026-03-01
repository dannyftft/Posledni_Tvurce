package hra;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HracTest {

    // Ověří že zdraví hráče neklesne pod 0
    @Test
    void zran() {
        Hrac hrac = new Hrac();
        hrac.setMaxZdravi(100);
        hrac.setZdravi(100);

        hrac.zran(999);

        assertEquals(0, hrac.getZdravi());
        assertFalse(hrac.jeNazivu());
    }

    // Ověří že léčení nepřekročí maximální zdraví
    @Test
    void vylec() {
        Hrac hrac = new Hrac();
        hrac.setMaxZdravi(100);
        hrac.setZdravi(50);

        hrac.vylec(999);

        assertEquals(100, hrac.getZdravi());
    }

    // Ověří že zvýšení síly se správně přičte k útoku
    @Test
    void zvysSilu() {
        Hrac hrac = new Hrac();
        hrac.setUtok(10);

        hrac.zvysSilu(5);

        assertEquals(15, hrac.getUtok());
    }
}