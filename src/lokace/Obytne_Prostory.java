package lokace;

import predmety.Karta;

public class Obytne_Prostory extends Lokace {
    public Obytne_Prostory() {
        super("obytne");
        this.nazev = "Obytné prostory";
        this.zamcena = false;
        this.pozadovanaUrovenKarty = 0;
    }
    public void vylepsitKartu(Karta karta){
        karta.vylepsit();
    }
}