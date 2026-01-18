package postavy;

public class Aurora extends Postava {
    private boolean aktivni;

    public Aurora() {
        super("aurora");
        this.aktivni = true;
    }


    @Override
    public String[] getDialogVolby() {
        // Načte z Resources/postavy.txt
        // Možná rozdělí podle řádků
        // Vrátí pole stringů
        return new String[0];
    }

    @Override
    public String getDialogOdpoved(int cisloVolby) {
        // Načte z Resources/postavy.txt
        // Vrátí celý text odpovědi
        return "";
    }

    @Override
    public boolean muzeMluvit() {
        //S Aurorou jde vzdy mluvit
        return true;
    }
}