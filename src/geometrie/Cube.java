package geometrie;

public class Cube extends Forme3D implements Affichable {
    private double cote;

    public Cube(double cote, String couleur) {
        super(couleur);
        this.cote = cote;
    }

    @Override
    public double calculerVolume() {
        return Math.pow(cote, 3);
    }

    @Override
    public void afficherInfo() {
        System.out.println("Cube - Côté : " + cote);
        System.out.println("Volume : " + calculerVolume());
        System.out.println("Couleur : " + getColor());
    }
}
