package generics.boite;

import generics.boite.contenu.*;

public class Empaquetage {
    public static void main(String[] args) {
        Boite<Gens> boiteDeNuit = new Boite<>();
        boiteDeNuit.add(new Gens());

        boiteDeNuit.afficherContenu();

        Boite<Commestibles> boiteDeCereales = new Boite<>();
        boiteDeCereales.add(new Cereales());
        boiteDeCereales.afficherContenu();

        BoiteDeCommestibles<Commestibles> boiteDeCommestibles = new BoiteDeCommestibles<>();
        boiteDeCommestibles.add(new Friandise());

        BoiteDeVivants<Vivant> vivantBoiteDeVivants = new BoiteDeVivants<>();
        vivantBoiteDeVivants.add(new Gens());


    }
}
