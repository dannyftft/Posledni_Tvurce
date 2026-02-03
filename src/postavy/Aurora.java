package postavy;

import data.Cteni;
import hra.HraData;

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
        return Cteni.nactiDialogVolby(this.id, aktualniLokace);
    }

    @Override
    public String getDialogOdpoved(int cisloVolby) {
        if (!aktivni) {
            return "Aurora mlčí.";
        }
        return Cteni.nactiDialogOdpoved(this.id, aktualniLokace, cisloVolby);
    }

    @Override
    public String getUvodniDialog(String lokaceId) {
        this.aktualniLokace = lokaceId;
        return Cteni.nactiUvodniDialog(this.id, lokaceId);
    }

    @Override
    public boolean muzeMluvit() {
        return aktivni;
    }

    @Override
    public void nastavLokaci(String lokaceId) {
        this.aktualniLokace = lokaceId;
    }


    public boolean jeAktivni() {
        return aktivni;
    }
}