package heritage.Jeu;

public class Jeu {
    public static void main(String[] args) {
        Joueur joueur = new Joueur("Pascal",5,3);

        // Affichage des informations du joueur
        joueur.getInformations();
        joueur.getNombreDeVies();

        // Création d'une instance d'Ennemi
        Ennemi ennemi = new Ennemi("Goblin",3, 10,10);

        // Affichage des informations de l'ennemi
        ennemi.getInformations();
        ennemi.getForce();
        ennemi.getNombreDeVies();

        do{
            joueur.attaquer(ennemi);
            if(ennemi.getNombreDeVies()>0)
                ennemi.attaquer(joueur);

        }while(joueur.getNombreDeVies()>0 && ennemi.getNombreDeVies()>0);
        if(joueur.getNombreDeVies()>0)
            System.out.println("Joueur à gagné");
        else
            System.out.println("Joueur a perdu");
    }
}
