package heritage.Jeu;

public class Personnage {

    private String nom;
    private int niveau;
    private int nombreDeVies;

    public void getInformations() {
        System.out.println("Nom : " + nom);
        System.out.println("Niveau : " + niveau);
    }

    public int getNombreDeVies() {
        return nombreDeVies;
    }

    public void setNombreDeVies(){
        this.nombreDeVies -= 1;
    }

    public Personnage(String nom, int niveau, int nombreDeVies){
        this.nom=nom;
        if(niveau>=0)
            this.niveau=niveau;
        if(nombreDeVies>0)
            this.nombreDeVies=nombreDeVies;
    }

    public void attaquer(Personnage p){
        System.out.println("J'attaque");
    };
}
