package postavy;

import hra.HraData;

public class PoskozenyRobot extends Postava {

    public PoskozenyRobot(HraData.PostavaData data) {
        super(data);

    }

    @Override
    public String[] getDialogVolby(String lokace) {
        // Pokud neporavený nečte malý text o tom jak není opravený možná z Recources.postavy.txt nebo univerzální error soubor
        // Pokud opraven: načte z Resources/postavy.txt
        return new String[0];
    }

    @Override
    public String getDialogOdpoved(String lokace, int cisloVolby) {
        // Pokud neoporavený nečte malý text o tom jak není opravený možná z Recources.postavy.txt nebo univerzální error soubor
        // Pokud opraven: načte z Resources/postavy.txt
        // Obsahuje lore o minulosti komplexu btw
        return "";
    }

    @Override
    public String getUvodniDialog(String lokace) {
        return "";
    }

    @Override
    public boolean muzeMluvit() {
        // Pokud oprvaný a ve správné místnosti (Servis) tak = true
        return false;
    }

    public void opravit() {
        opraven = true;
    }
}