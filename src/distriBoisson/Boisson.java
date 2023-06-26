package distriBoisson;

import java.util.ArrayList;
import java.util.List;

public class Boisson {

    // 1.Variables

    private String nom;
    private int quantite;
    private ArrayList<String> listeIngredient = new ArrayList<>();

    //2. Encapsulation

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if(nom.length()>0)
            this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        if(quantite>0)
            this.quantite = quantite;
    }

    public List<String> getListeIngredient() {
        return List.copyOf(listeIngredient);
    }

    public void setListeIngredient(ArrayList<String> listeIngredient) {
        this.listeIngredient = listeIngredient;
    }

    //3.Constructeur

    public Boisson(String nom, int quantite){
        setNom(nom);
        setQuantite(quantite);
    }

    //4.Méthodes

    public void affichage(){
        System.out.println("Voici un" + this.nom);
        System.out.println("Il en reste " + (--this.quantite));
    }
}
