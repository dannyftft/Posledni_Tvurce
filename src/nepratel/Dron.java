package nepratel;

public class Dron extends Nepritel {

    public Dron(int zdravi, int poskozeni) {
        super("dron", zdravi, poskozeni);
    }

    public void poskozeniKamenem() {
        // Okamžitě nastaví zdravi na 0 nebo sníží zdraví o více zatím nvm
    }
}