package distriBoisson;

public class Boisson {

    String nom;
    int quantite;

    public Boisson(String nom, int quantite){
        this.nom = nom;
        this.quantite = quantite;
    }

    public void affichage(){
        System.out.println("Voici un" + this.nom);
        System.out.println("Il en reste " + (--this.quantite));
    }
}
