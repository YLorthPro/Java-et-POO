package enums;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Entrez un mois: ");

        String input = scanner.next().toUpperCase();
        try{
            Mois mois = Mois.valueOf(input);
            int nombreJours = mois.getNombreJours();

            System.out.println("Le mois de " + mois + " contient " + nombreJours + " jours.");
        }catch(IllegalArgumentException ex){
            System.out.println("Oups, il y a eu une erreur:");
            System.out.println(ex);
        }finally {
            System.out.println("Au revoir!");
        }

    }
}
