package parking;

import java.util.LinkedList;

public class Parking<V extends Vehicule> {

    public static final int MAX_FLOOR = 'Z' - 'A' + 1;
    public static final int PLACE_PER_FLOOR = 20;
    public static final int MAX_SIZE = MAX_FLOOR * PLACE_PER_FLOOR;


    private final int capacity;
    private final Vehicule[][] places;
    private final LinkedList<String> priorityFreePlace = new LinkedList<>();


    public Parking(int capacity) {
        if (capacity < 1 || capacity > MAX_SIZE)
            throw new IllegalArgumentException("nbrPlace: min 1, max 520");

        this.capacity = capacity;
        this.places = generateParking();
        priorityFreePlace.add("A01");
    }

    // Méthode pour calculer la quantité d'étages en fonction de la capacité
    private int getFloorQtt() {
        return (capacity / 20) + (capacity % 20 > 0 ? 1 : 0);
    }

    // Méthode pour vérifier si le parking est plein
    public boolean isFull() {
        for (Vehicule[] place : places) {
            for (Vehicule vehicule : place) {
                if (vehicule == null)
                    return false;
            }
        }
        return true;
    }

    // Méthode pour générer le tableau de places de stationnement en fonction de la capacité
    private Vehicule[][] generateParking() {
        Vehicule[][] places = new Vehicule[getFloorQtt()][];

        // Assignation du nombre de places par étage sauf pour le dernier étage
        for (int i = 0; i < getFloorQtt() - 1; i++) {
            places[i] = new Vehicule[PLACE_PER_FLOOR];
        }

        // Calcul du nombre de places pour le dernier étage en fonction de la capacité restante
        int placeOnLast = capacity % PLACE_PER_FLOOR > 0 ? capacity % PLACE_PER_FLOOR : PLACE_PER_FLOOR;
        places[getFloorQtt() - 1] = new Vehicule[placeOnLast];
        return places;
    }

    // Méthode pour obtenir le code de la place précédente par rapport à un code donné
    private String previousPlace(String code) {
        // Vérification de la validité du code et des conditions pour obtenir la place précédente
        if (code == null || isCodeInvalid(code))
            throw new PlaceCodeException(code);

        // Gestion du cas spécial pour la première place
        if (code.equals("A01"))
            return null;

        // Calcul de l'index de la place précédente
        int nextPlaceIndex = placeIndex(code) - 1;
        int nextFloorIndex = floorIndex(code);
        if (nextPlaceIndex < 0) {
            nextPlaceIndex = PLACE_PER_FLOOR - 1;
            nextFloorIndex--;
        }

        // Conversion de l'index en code de place et vérification de sa validité
        String nextPlace = toCode(nextFloorIndex, nextPlaceIndex);
        return placeIsPossible(nextPlace) ? nextPlace : null;
    }

    // Méthode pour obtenir le code de la place suivante par rapport à un code donné
    private String nextPlace(String code) {
        // Vérification de la validité du code et des conditions pour obtenir la place suivante
        if (code == null || isCodeInvalid(code))
            throw new PlaceCodeException(code);

        // Gestion du cas spécial pour la dernière place
        if (code.equals("Z20"))
            return null;

        // Calcul de l'index de la place suivante
        int nextPlaceIndex = placeIndex(code) + 1;
        int nextFloorIndex = floorIndex(code);
        if (nextPlaceIndex >= PLACE_PER_FLOOR) {
            nextPlaceIndex = 0;
            nextFloorIndex++;
        }

        // Conversion de l'index en code de place et vérification de sa validité
        String nextPlace = toCode(nextFloorIndex, nextPlaceIndex);
        return placeIsPossible(nextPlace) ? nextPlace : null;
    }

    //Méthode pour ajouter un véhicule
    public String add(V vehicule){
        if( isFull() )
            throw new ParkingFullException();

//        if(priorityFreePlace.isEmpty())
//            throw new ParkingFullException();

        if( vehicule == null )
            throw new IllegalArgumentException();

        //Prends le premier élément de ma liste priorityFreePlace
        String code = priorityFreePlace.pop();

        //Place le véhicule à cette place
        places[floorIndex(code)][placeIndex(code)] = vehicule;

        //S'assurer que la prochaine place libre possible est ajoutée à la liste priorityFreePlace
        priorityFreePlace.remove(code);
        String nextPlace = nextPlace( code );
        if( !isCodeInvalid(code)
                && placeIsPossible(nextPlace)
                && get( nextPlace ) == null ){
            placeIntoPriority(nextPlace); // De facon à avoir des places croissantes
        }
        return code;
    }

    // Méthode pour obtenir un véhicule à partir du code de place donné
    private V get(String code) {
        // Vérification de la validité du code et de la disponibilité de la place
        if (isCodeInvalid(code) || !placeIsPossible(code))
            throw new PlaceCodeException(code);

        // Récupération du véhicule à partir du tableau de places
        return (V) places[floorIndex(code)][placeIndex(code)];
    }

    // Méthode pour retirer un véhicule du parking en utilisant le code de place
    public V remove(String code) {
        // Récupération du véhicule à retirer
        V removed = get(code);

        // Retrait du véhicule du tableau de places
        places[floorIndex(code)][placeIndex(code)] = null;

        // Gestion de la place précédente et suivante dans la liste des places prioritaires libres
        if (code.equals("A01") || get(previousPlace(code)) != null)
            placeIntoPriority(code);
        priorityFreePlace.remove(nextPlace(code));

        // Affichage d'un message si le véhicule a été retiré
        if (removed != null)
            System.out.println(removed.getMarque() + " - " + removed.getModele() + " leave the parking");

        return removed;
    }

    // Méthode pour ajouter une place libre dans la liste des places prioritaires libres
    private void placeIntoPriority(String code) {
        if (!placeIsPossible(code))
            return;

        // Ajout de la place en tant que première place si la liste est vide
        if (priorityFreePlace.isEmpty())
            priorityFreePlace.addFirst(code);
        else {
            // Parcours de la liste pour insérer la place à l'endroit approprié
            for (int i = 0; i < priorityFreePlace.size(); i++) {
                if (compare(code, priorityFreePlace.get(i)) < 0) {
                    priorityFreePlace.add(i, code);
                    return;
                }
            }
        }
    }

    // Méthode pour obtenir le code de la prochaine place prioritaire libre
    public String nextPriority() {
        return priorityFreePlace.getFirst();
    }

    // Méthode pour convertir un index d'étage et un index de place en code de place
    private static String toCode(int indexEtage, int indexPlace) {
        return String.format("%c%02d", indexEtage + 'A', indexPlace + 1);
    }

    // Méthode pour obtenir l'index d'étage à partir d'un code de place
    private static int floorIndex(String code) {
        if (isCodeInvalid(code))
            throw new PlaceCodeException(code);

        return code.charAt(0) - 'A';
    }

    // Méthode pour obtenir l'index de place à partir d'un code de place
    private static int placeIndex(String code) {
        if (isCodeInvalid(code))
            throw new PlaceCodeException(code);

        return Integer.parseInt(code.substring(1)) - 1;
    }

    // Méthode pour comparer deux codes de place et déterminer leur ordre
    private static int compare(String code1, String code2) {
        int index1 = floorIndex(code1) * PLACE_PER_FLOOR + placeIndex(code1);
        int index2 = floorIndex(code2) * PLACE_PER_FLOOR + placeIndex(code2);
        return index1 - index2;
    }

    // Méthode pour vérifier si une place est possible en fonction de sa capacité
    private boolean placeIsPossible(String code) {
        if (code == null)
            return false;

        return (floorIndex(code) * PLACE_PER_FLOOR + placeIndex(code)) < capacity;
    }

    // Méthode pour vérifier si un code de place est invalide
    private static boolean isCodeInvalid(String code) {
        if (code == null)
            return true;

        if (code.length() != 3)
            return true;

        char etage = code.charAt(0);
        if (etage < 'A' || etage > 'Z')
            return true;

        try {
            int placeNumber = Integer.parseInt(code.substring(1));
            if (placeNumber < 1 || placeNumber > PLACE_PER_FLOOR)
                return true;
        } catch (NumberFormatException ex) {
            return true;
        }

        return false;
    }



}
