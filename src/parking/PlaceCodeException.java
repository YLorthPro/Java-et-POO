package parking;

public class PlaceCodeException extends RuntimeException {

    private final String code;

    public PlaceCodeException(String code) {
        super(code + " is not a valid code for this parking");
        this.code = code;
    }

}
