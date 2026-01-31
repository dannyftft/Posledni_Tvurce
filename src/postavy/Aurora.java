//TODO aurora reaguje na hráče. Nejlepší způsob: nová reakce/konverzace pro každou místnost

package postavy;

import data.Cteni;
import hra.HraData;

public class Aurora extends Postava {
    public String aktualniLokace;

    public Aurora(HraData.PostavaData data) {
        super(data);
    }

    @Override
    public String[] getDialogVolby(String lokace) {
        if (!aktivni) {
            return new String[]{"Aurora neodpovídá."};
        }
        return Cteni.nactiDialogVolby(this.id, aktualniLokace);
    }

    @Override
    public String getDialogOdpoved(String lokace, int cisloVolby) {
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


    public boolean jeAktivni() {
        return aktivni;
    }
}