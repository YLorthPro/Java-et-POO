package geometrie;

public abstract class Forme3D extends Forme{

    public Forme3D(String couleur) {
        super(couleur);
    }

    public abstract double calculerVolume();
}
