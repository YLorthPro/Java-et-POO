package enums;

import java.util.Scanner;

public class Planetarium {
    public static void afficherCaracteristiquesPlanete(Planete planete) {
        System.out.println("Masse de " + planete + ": " + planete.getMasse() + " kg");
        System.out.println("Distance par rapport au Soleil: " + planete.getDistanceAuSoleil() + " millions de kilomètres");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez une planète (par exemple: TERRE): ");
        String input = scanner.next().toUpperCase();

        Planete planete = Planete.valueOf(input);
        afficherCaracteristiquesPlanete(planete);
    }
}
