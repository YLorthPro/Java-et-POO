package geometrie;

public abstract class Forme implements Coloriable{
    private String couleur;

    public Forme(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public String getColor() {
        return couleur;
    }
}
