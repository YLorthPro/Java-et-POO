import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        Scanner scanner = new Scanner(System.in);

        String chaine = scanner.nextLine();
        int nombre = Integer.parseInt(chaine);

        int nombreAleatoire = 0 + (int)(Math.random() * ((10 - 0) + 1));

        System.out.println("Bravo le nombre était: " + chaine);
        System.out.println(nombreAleatoire);

        //Une ligne de commentaire

        /*
        feqrferf
        qferfqerfreqfqrf
        rfqerfqeferqf
        fghrchgn,u
         */




    }
}