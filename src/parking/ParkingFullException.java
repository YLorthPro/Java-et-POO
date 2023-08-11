package parking;

public class ParkingFullException extends RuntimeException {

    public ParkingFullException() {
        super("This parking is full");
    }
}
