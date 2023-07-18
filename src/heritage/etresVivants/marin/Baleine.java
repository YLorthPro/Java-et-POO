package heritage.etresVivants.marin;

import heritage.etresVivants.Mammifere;

public class Baleine extends Marin implements Mammifere {
    private double poids;

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        if(poids>0)
            this.poids = poids;
    }

    public Baleine(int nbNageoire, double poids) {
        super(nbNageoire);
        this.poids = poids;
    }

    @Override
    public void accoucher() {
        System.out.println("Coucou");
    }

    @Override
    public void allaiter() {
		setPoids(25);
    }
}
