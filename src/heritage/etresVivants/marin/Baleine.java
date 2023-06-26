package heritage.etresVivants.marin;

public class Baleine extends Marin {
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
}
