package hra;

import lokace.Lokace;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HraTest {

    // Ověří že pohyb do sousední lokace správně změní aktuální lokaci
    @Test
    void ZmenaLokace() {
        Hra hra = new Hra();
        hra.vytvorMapu();
        Lokace sousedniLokace = hra.getAktualniLokace().getSousedniLokace().get(0);
        hra.ZmenaLokace(sousedniLokace);

        assertEquals(sousedniLokace.getId(), hra.getAktualniLokace().getId());
    }
}