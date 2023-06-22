package todo;

import java.time.LocalDate;
public class Tache {
    protected String nom;
    public LocalDate date;
    public String description;

    public Tache(String nom, LocalDate date, String description) {
        this.nom = nom;
        this.date = date;
        this.description = description;
    }

    public void affichage(){
        System.out.println("Je suis une tache");
    }
}
