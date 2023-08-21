package parking;

public class Moto extends Vehicule{

    private final Carburant carburant;

    public Moto(String marque, String modele, Carburant carburant) {
        super(marque, modele);
        this.carburant = carburant;
    }

    public Carburant getCarburant() {
        return carburant;
    }

}
