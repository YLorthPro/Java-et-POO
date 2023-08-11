package parking;

public class Voiture extends Vehicule {

    private final Carburant carburant;

    public Voiture(String marque, String modele, Carburant carburant) {
        super(marque, modele);
        this.carburant = carburant;
    }

    public Carburant getCarburant() {
        return carburant;
    }
}
