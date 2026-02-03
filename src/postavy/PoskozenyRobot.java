package postavy;

import data.Cteni;
import hra.HraData;

public class PoskozenyRobot extends Postava {

    public PoskozenyRobot(HraData.PostavaData data) {
        super(data);

    }

    @Override
    public String[] getDialogVolby() {
        if (!aktivni) {
            return new String[]{"Robot je nefunkční a neodpovídá."};
        }
        return Cteni.nactiDialogVolby(this.id, "servis");
    }

    @Override
    public String getDialogOdpoved(int cisloVolby) {
        if (!aktivni) {
            return "Robot tiše leží bez reakce.";
        }
        return Cteni.nactiDialogOdpoved(this.id, "servis", cisloVolby);
    }


    @Override
    public String getUvodniDialog(String lokace) {
        if(!aktivni){
            return "Robot tiše leží bez reakce.";
        }
        return Cteni.nactiUvodniDialog(this.id, "servis");
    }

    @Override
    public boolean muzeMluvit() {
        return aktivni;
    }

    public void opravit() {
        aktivni = true;
    }
}