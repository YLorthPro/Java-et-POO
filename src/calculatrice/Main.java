package calculatrice;

public class Main {
    public static void main(String[] args) {
        try {
            double a = 10;
            double b = 0;

            System.out.println("Addition: " + Calculatrice.effectuerOperation(Operation.ADDITION, a, b));

            System.out.println("Soustraction: " + Calculatrice.effectuerOperation(Operation.SOUSTRACTION, a, b));

            System.out.println("Multiplication: " + Calculatrice.effectuerOperation(Operation.MULTIPLICATION, a, b));

            System.out.println("Division: " + Calculatrice.effectuerOperation(Operation.DIVISION, a, b));

        } catch (UnsupportedOperationException e) {
            System.out.println("Erreur d'opérateur: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Erreur arithmétique: " + e.getMessage());
        }
    }
}
