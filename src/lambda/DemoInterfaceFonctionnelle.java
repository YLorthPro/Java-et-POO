package lambda;

public class DemoInterfaceFonctionnelle {

    public static void main(String[] args) {

        // Utilisation de l'interface fonctionnelle avec une expression lambda
        Calculateur addition = (a, b) -> a + b;
        Calculateur soustraction = (a, b) -> a - b;

        // Utilisation des fonctions définies par l'interface fonctionnelle
        int resultatAddition = effectuerOperation(5, 3, addition);
        int resultatSoustraction = effectuerOperation(10, 4, soustraction);

        System.out.println("Résultat de l'addition : " + resultatAddition);
        System.out.println("Résultat de la soustraction : " + resultatSoustraction);
    }

    // Méthode qui utilise l'interface fonctionnelle pour effectuer une opération
    public static int effectuerOperation(int a, int b, Calculateur calculateur) {
        return calculateur.calcul(a, b);
    }
}

