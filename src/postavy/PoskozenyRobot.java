package postavy;

public class PoskozenyRobot extends Postava {
    private boolean opraven;

    public PoskozenyRobot() {
        super("poskozenyRobot");
        this.opraven = false;
    }

    @Override
    public String[] getDialogVolby() {
        // Pokud neporavený nečte malý text o tom jak není opravený možná z Recources.postavy.txt nebo univerzální error soubor
        // Pokud opraven: načte z Resources/postavy.txt
        return new String[0];
    }

    @Override
    public String getDialogOdpoved(int cisloVolby) {
        // Pokud neoporavený nečte malý text o tom jak není opravený možná z Recources.postavy.txt nebo univerzální error soubor
        // Pokud opraven: načte z Resources/postavy.txt
        // Obsahuje lore o minulosti komplexu btw
        return "";
    }

    @Override
    public boolean muzeMluvit() {
        // Pokud oprvaný a ve správné místnosti (Servis) tak = true
        return false;
    }

    public void opravit() {
        // Nastaví opraven na true pokud hráč použije Energetické Jádro
    }
}