package heritage.etresVivants.terrestre;

import heritage.etresVivants.marin.EtreVivants;

public class Terrestre extends EtreVivants {
    private boolean marche;

    public boolean isMarche() {
        return marche;
    }

    protected Terrestre(boolean marche) {
        this.marche = marche;
    }

    public void seDeplacer(){
        System.out.println("Je me déplace");
    }
}
