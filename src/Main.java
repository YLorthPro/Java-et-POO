import exception.GeoffreyException;
import heritage.etresVivants.marin.Baleine;
import heritage.etresVivants.marin.Poisson;
import heritage.etresVivants.terrestre.Chien;
import heritage.etresVivants.terrestre.Serpent;
import parking.Carburant;
import parking.Vehicule;
import parking.Voiture;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Chien chien = new Chien("Pluto");
        Serpent serpent = new Serpent();
        Poisson poisson = new Poisson(5);
        Baleine baleine = new Baleine(3,1234.56);

        try{
            int nb = 8;
            System.out.println("Entrez un chiffre entre 0 et 6 inclus");
            if(nb < 0 || nb >6)
                throw new GeoffreyException("Oui mais....");

            System.out.println("coucou");
        }catch(GeoffreyException ex){
            System.out.println(ex);
        }

        //ASCII

        Optional<Voiture> opt = Optional.of(new Voiture("peu","308",Carburant.ESSENCE));

        opt = Optional.empty();

        System.out.println(opt.isPresent());

    }

}
