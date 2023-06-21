import java.util.Scanner;

public class DistributeurDeBoissons {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Boisson maBoisson =new Boisson();
        maBoisson.nom="cola";
        maBoisson.quantite=3;

        System.out.println(maBoisson);


        String choixUtilisateur;
        String autreChoix;

        boolean repeat;

        do {
            System.out.println("Quelle boisson voulez vous? 1.Cola - 2.Eau plate - 3.Eau gazeuse");
            choixUtilisateur = sc.nextLine();

            switch (choixUtilisateur){
                case "1":
                    System.out.println("Voici un cola!");
                    break;
                case "2":
                    System.out.println("Voici une eau plate!");
                    break;
                case "3":
                    System.out.println("Voici une eau gazeuse!");
                    break;
                default:
                    System.out.println("Boisson non connue");
            }

            do {
                System.out.println("Voulez-vous une autre boisson? Oui (O), non (N)");
                autreChoix = sc.nextLine();

                if("o".equals(autreChoix.toLowerCase()))
                    repeat=true;
                else
                    repeat=false;
            }while(!autreChoix.toLowerCase().equals("o") && !autreChoix.toLowerCase().equals("n"));

        }while (repeat);

        System.out.println("Au revoir!");

    }
}
