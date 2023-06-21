import java.util.Scanner;

public class DistributeurDeBoissons {

    public static void main(String[] args) {
        // On importe la classe Scanner pour pouvoir lire les entrées
        Scanner sc = new Scanner(System.in);

        // On crée 3 objets de la classe Boisson avec des noms et des quantités différentes
        Boisson maBoisson = new Boisson();
        maBoisson.nom="cola";
        maBoisson.quantite=3;

        Boisson maBoisson2 = new Boisson();
        maBoisson2.nom="Eau plate";
        maBoisson2.quantite=2;

        Boisson maBoisson3 = new Boisson();
        maBoisson3.nom="Eau gazeuse";
        maBoisson3.quantite=5;

        // On initialise des variables pour stocker les choix de l'utilisateur
        String choixUtilisateur;
        String autreChoix;

        // On initialise une variable pour savoir si l'utilisateur veut continuer de commander
        boolean repeat;

        // On utilise une boucle do-while pour continuer la commande tant que l'utilisateur le souhaite et que des boissons sont disponibles
        do {
            // On demande à l'utilisateur quelle boisson il souhaite
            System.out.println("Quelle boisson voulez vous? 1.Cola - 2.Eau plate - 3.Eau gazeuse");
            choixUtilisateur = sc.nextLine();

            // On utilise l'instruction switch pour récupérer la boisson choisie par l'utilisateur
            Boisson lElue = null;

            switch (choixUtilisateur){
                case "1":
                    lElue = maBoisson;
                    break;

                case "2":
                    lElue = maBoisson2;
                    break;

                case "3":
                    lElue = maBoisson3;
                    break;

                default:
                    lElue = null;
            }

            // On vérifie si la quantité de la boisson est supérieure à 0 pour la servir à l'utilisateur

            if(lElue.quantite>0){
                System.out.println("Voici un "+ lElue.nom);
                System.out.println("Quantité restante: "+ (--lElue.quantite));;
            } else
                System.out.println("Nous n'avons plus de "+lElue.nom);

            // On utilise une autre boucle do-while pour demander à l'utilisateur s'il souhaite commander une autre boisson
            do {
                System.out.println("Voulez-vous une autre boisson? Oui (O), non (N)");
                autreChoix = sc.nextLine();

                if("o".equals(autreChoix.toLowerCase()))
                    repeat=true;
                else
                    repeat=false;
            }while(!autreChoix.toLowerCase().equals("o") && !autreChoix.toLowerCase().equals("n"));

        }while (repeat && (maBoisson.quantite + maBoisson2.quantite+ maBoisson3.quantite >0));

        // Si toutes les boissons sont épuisées, on affiche un message à l'utilisateur
        if(maBoisson.quantite + maBoisson2.quantite+ maBoisson3.quantite==0)
            System.out.println("Plus de boissons disponibles");

        System.out.println("Au revoir!");

    }
}
