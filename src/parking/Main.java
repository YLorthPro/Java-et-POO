package parking;

public class Main {

    public static void main(String[] args) {

        Parking<Velo> parking = new Parking<>(40);

        Velo v = new Velo("Cannondale","Trail 6","rouge");

        parking.add(v);

        System.out.println(parking.nextPriority());

        Velo removed = parking.remove("A01");

        System.out.println(parking.nextPriority());

        for (int i = 0; i <30 ; i++) {
            parking.add(new Velo("Decathlon","BTwin","bleu"));
        }

        System.out.println(parking.nextPriority());

        parking.add(v);


        System.out.println(parking.nextPriority());
        parking.remove("A03");

        System.out.println(parking.nextPriority());

        parking.remove("A05");



        System.out.println(parking.isFull());
    }

}
