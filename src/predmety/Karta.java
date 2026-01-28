package predmety;

import hra.Hra;

public class Karta extends Predmet {
    private int uroven;

    public Karta() {
        super("karta","Přístupová karta");
        this.uroven = 1;
    }

    @Override
    public String pouzit(Hra hra) {
        return "Karta se používá automaticky při otevírání dveří.";
    }

    @Override
    public boolean jeSpotrebovatelny() {
        return false;
    }

    @Override
    public boolean zabiraSlot() {
        return false;
    }

    public void vylepsit() {
        this.uroven = 2;
    }

    public int getUroven() {
        return uroven;
    }
}