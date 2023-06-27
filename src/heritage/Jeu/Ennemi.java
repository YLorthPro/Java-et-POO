package heritage.Jeu;

public class Ennemi extends Personnage{
    private int force;

    public int getForce() {
        return force;
    }

    public Ennemi(String nom, int niveau, int nombreDeVies, int force) {
        super(nom, niveau, nombreDeVies);
        if(force>=0)
            this.force = force;
    }

    @Override
    public void attaquer(Personnage p) {
        super.attaquer(p);
        System.out.println("J'ai une force de: " + getForce());
        int rdm = getForce() + (int)(Math.random() * ((100 - getForce()) + 1));

        if(rdm>60){
            p.setNombreDeVies();
            System.out.println("Attaque réussie");
        } else
            System.out.println("Attaque échouée");

        System.out.println("Nombre de vies restantes: " + p.getNombreDeVies());
    }
}
