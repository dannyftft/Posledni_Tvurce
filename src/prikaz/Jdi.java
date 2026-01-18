package prikaz;

import hra.Hra;

public class Jdi extends Prikaz {
    public Jdi(Hra hra) {
        super(hra);
    }

    @Override
    public String execute() {
        /*
            TODO zobrazí očíslovaný seznam místností, do kterých lze z aktuální lokace jít
            jdi <číslo> přesune hráče do vybrané místnosti, pokud je přístupná

         */
        return null;
    }

    @Override
    public boolean exit() {
        return false;
    }
}