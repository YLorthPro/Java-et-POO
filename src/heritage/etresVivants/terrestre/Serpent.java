package heritage.etresVivants.terrestre;

import heritage.etresVivants.Mammifere;
import heritage.etresVivants.Ovipare;

public class Serpent extends Terrestre implements Ovipare {
    public Serpent(){
        super(false);
    }

    @Override
    public void pondre(int nbOeufs) {
        System.out.println("J'ai pondu " + nbOeufs + " oeufs!");
    }
}
