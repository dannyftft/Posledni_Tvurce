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
        return Cteni.DialogVolby(this.id, "servis");
    }

    @Override
    public String getDialogOdpoved(int cisloVolby) {
        if (!aktivni) {
            return "\nRobot tiše leží bez reakce.";
        }
        return Cteni.DialogOdpoved(this.id, "servis", cisloVolby);
    }


    @Override
    public String getUvodniDialog(String lokace) {
        if(!aktivni){
            return "\nRobot tiše leží bez reakce.";
        }
        return Cteni.UvodniDialog(this.id, "servis");
    }

    @Override
    public boolean muzeMluvit() {
        return aktivni;
    }

    public void opravit() {
        aktivni = true;
    }
}