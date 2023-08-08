package calculatrice;

public class Calculatrice {
    public static double effectuerOperation(Operation operation, double a, double b) throws UnsupportedOperationException, ArithmeticException {
        switch (operation) {
            case ADDITION:
                return a + b;
            case SOUSTRACTION:
                return a - b;
            case MULTIPLICATION:
                return a * b;
            case DIVISION:
                if (b == 0) {
                    throw new ArithmeticException("Division par zéro impossible");
                }
                return a / b;
            default:
                throw new UnsupportedOperationException("Opération non supportée");
        }
    }
}
