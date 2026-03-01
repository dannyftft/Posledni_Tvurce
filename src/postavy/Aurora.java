package postavy;

import data.Cteni;
import hra.HraData;

// Třída představující umělou inteligenci Aurora
public class Aurora extends Postava {
    public String aktualniLokace;

    public Aurora(HraData.PostavaData data) {
        super(data);
    }

    @Override
    public String[] getDialogVolby() {
        if (!aktivni) {
            return new String[]{"Aurora neodpovídá."};
        }
        return Cteni.DialogVolby(this.id, aktualniLokace);
    }

    @Override
    public String getDialogOdpoved(int cisloVolby) {
        if (!aktivni) {
            return "Aurora mlčí.";
        }
        return Cteni.DialogOdpoved(this.id, aktualniLokace, cisloVolby);
    }

    @Override
    public String getUvodniDialog(String lokaceId) {
        this.aktualniLokace = lokaceId;
        return Cteni.UvodniDialog(this.id, lokaceId);
    }

    @Override
    public boolean muzeMluvit() {
        return aktivni;
    }
}