package distriBoisson;

import java.util.Scanner;

public class DistributeurDeBoissons {

    public static void main(String[] args) {
        // On importe la classe Scanner pour pouvoir lire les entrées
        Scanner sc = new Scanner(System.in);

        //On crée 3 objets de la classe distriBoisson.Boisson avec des noms et des quantités différentes
        Boisson maBoisson = new Boisson("cola",3);

        Boisson maBoisson2 = new Boisson("Eau plate",2);

        Boisson maBoisson3 = new Boisson("Eau gazeuse",5);

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

            System.out.println(maBoisson.getListeIngredient());

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

            if(lElue.getQuantite()>0){
                lElue.affichage();
            } else
                System.out.println("Nous n'avons plus de "+lElue.getNom());

            // On utilise une autre boucle do-while pour demander à l'utilisateur s'il souhaite commander une autre boisson
            do {
                System.out.println("Voulez-vous une autre boisson? Oui (O), non (N)");
                autreChoix = sc.nextLine();

                if("o".equals(autreChoix.toLowerCase()))
                    repeat=true;
                else
                    repeat=false;
            }while(!autreChoix.toLowerCase().equals("o") && !autreChoix.toLowerCase().equals("n"));

        }while (repeat && (maBoisson.getQuantite() + maBoisson2.getQuantite()+ maBoisson3.getQuantite() >0));

        if(maBoisson.getQuantite() + maBoisson2.getQuantite()+ maBoisson3.getQuantite()==0)
            System.out.println("Plus de boissons disponibles");

        System.out.println("Au revoir!");
    }

}
