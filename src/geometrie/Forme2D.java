package geometrie;

public abstract class Forme2D extends Forme{

    public Forme2D(String couleur) {
        super(couleur);
    }

    public abstract double calculerAire();
    public abstract double calculerPerimetre();
}
