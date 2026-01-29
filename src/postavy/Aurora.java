package postavy;

import hra.HraData;

public class Aurora extends Postava {
    private boolean aktivni;

    public Aurora(HraData.PostavaData data) {
        super(data);
    }

    @Override
    public String[] getDialogVolby() {
        return new String[0];
    }

    @Override
    public String getDialogOdpoved(int cisloVolby) {
        return "";
    }

    @Override
    public boolean muzeMluvit() {
        return aktivni;
    }

    public boolean jeAktivni() {
        return aktivni;
    }
}