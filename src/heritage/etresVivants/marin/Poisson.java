package heritage.etresVivants.marin;

import heritage.etresVivants.Ovipare;

public class Poisson extends Marin implements Ovipare {
    public Poisson(int nbNageoire) {
        super(nbNageoire);
    }

    @Override
    public void pondre(int nbOeufs) {
        System.out.println("J'ai pondu " + nbOeufs + " oeufs!");
    }
}
