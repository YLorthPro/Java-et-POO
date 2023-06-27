package heritage.etresVivants.terrestre;

public class Chien extends Terrestre {
    private String nom;

    public Chien(String nom) {
        super(true);
        this.nom = nom;
    }

    public void abboyer(){
        System.out.println("Miaouw");
    }
}
