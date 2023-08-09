package generics;

import parking.Carburant;
import parking.Voiture;

public class Main {
    public static void main(String[] args) {
        CollectionLambda<Integer> collectionInt = new CollectionLambda<>(3);
        collectionInt.add(2);
        collectionInt.add(32);
        collectionInt.add(0);

        CollectionLambda<Voiture> collectionVoiture = new CollectionLambda<>(2);
        collectionVoiture.add(new Voiture("Peugeot","308", Carburant.ELECTRIQUE));
        collectionVoiture.add(new Voiture("Vw","passat", Carburant.DIESEL));


        collectionVoiture.afficherElement();
        collectionInt.afficherElement();

    }
}
