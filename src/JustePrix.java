import java.util.Scanner;

public class JustePrix {
    public static void main(String[] args) {

        // On importe la classe Scanner pour pouvoir récupérer les entrées de l'utilisateur
        Scanner sc = new Scanner(System.in);

        // On crée une variable pour stocker l'entrée de l'utilisateur sous forme de chaîne de caractères
        String entreeUtilisateur;

        // On crée une variable pour convertir l'entrée utilisateur en nombre
        int nombreEntreeUtilisateur;

        // On crée une variable pour compter le nombre de tentatives
        int cmpt =1;

        // On génère un nombre aléatoire entre 0 et 10 inclus grâce à la classe Math.random()
        int nombreAleatoire = 0 + (int)(Math.random() * ((10 - 0) + 1));

        // On boucle tant que l'entrée utilisateur n'est pas égale au nombre aléatoire et que le nombre de tentatives est inférieur ou égal à 10
        do{ System.out.println("Veuillez entrer un nombre: ");

            // On récupère l'entrée utilisateur sous forme de chaîne de caractères
            entreeUtilisateur = sc.nextLine();

            // On convertit l'entrée utilisateur en nombre
            nombreEntreeUtilisateur = Integer.parseInt(entreeUtilisateur);

            // On compare l'entrée utilisateur au nombre aléatoire et on affiche un message en conséquence
            if(nombreEntreeUtilisateur < nombreAleatoire)
                System.out.println("C'est plus!");
            else if(nombreEntreeUtilisateur > nombreAleatoire)
                System.out.println("C'est moins!");
            else
                System.out.println("Vous avez gagné!");

            // On incrémente le compteur de tentatives
            cmpt++;

        // On sort de la boucle si l'entrée utilisateur est égale au nombre aléatoire ou si le nombre de tentatives est supérieur à 10
        }while(nombreEntreeUtilisateur != nombreAleatoire && cmpt <=10);

        // On affiche le nombre de tentatives
        System.out.println("Nombre d'essai: "+cmpt);

        // Si le nombre de tentatives est supérieur à 10, on affiche un message de défaite
        if(cmpt >10) System.out.println("Vous avez perdu!");

        }
}
