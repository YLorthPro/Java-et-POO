package geometrie;

public class Carre extends Forme2D implements Affichable{
    private double cote;

    public Carre(double cote, String couleur) {
        super(couleur);
        this.cote = cote;
    }

    @Override
    public double calculerAire() {
        return cote * cote;
    }

    @Override
    public double calculerPerimetre() {
        return 4 * cote;
    }

    @Override
    public void afficherInfo() {
        System.out.println("Carré - Côté : " + cote);
        System.out.println("Aire : " + calculerAire());
        System.out.println("Périmètre : " + calculerPerimetre());
        System.out.println("Couleur : " + getColor());
    }

    public void test(){
        System.out.println("Je suis un carré");
    }
}
