package pimpedtodolist;

import java.time.LocalDate;

public class Tache implements Comparable<Tache> {

    private final String nom;
    private final LocalDate deadline;
    private final String description;
    private final Priorite priorite;

    public Tache(String nom, LocalDate deadline, String description, Priorite priorite) {
        this.nom = nom;
        this.deadline = deadline;
        this.description = description;
        this.priorite = priorite;
    }

    public String getNom() {
        return nom;
    }

    public Priorite getPriorite() {
        return priorite;
    }


    @Override
    public int compareTo(Tache tache) {
        if(tache == null)
            throw new IllegalArgumentException();

        return this.getPriorite().ordinal() - tache.getPriorite().ordinal();
    }
}
