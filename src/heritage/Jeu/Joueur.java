package heritage.Jeu;

public class Joueur extends Personnage{

    public Joueur(String nom, int niveau, int nombreVies) {
        super(nom, niveau, nombreVies);
    }

    @Override
    public void attaquer(Personnage p) {
        super.attaquer(p);
        p.setNombreDeVies();
        System.out.println("Nombre de vies restantes: " + p.getNombreDeVies());
    }
}
