public class Humain extends EtreVivant{

    String nom;
    String prenom;

    public Humain(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public void respirer() {
        super.respirer();
        System.out.println("J'ai pas envie");
    }

    @Override
    public String toString() {
        return "Mon nom est"+nom;
    }

}

