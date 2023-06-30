package heroesVSmonsters.personnages;

import heroesVSmonsters.utils.Tools;

public abstract class Personnage {

    //1. Variables

    private final int force;
    private final int endurance;
    private final int bonusForce;
    private final int bonusEndurance;
    private final int pointDeVie;
    private int pointDeVieActuel;
    private int or;
    private int cuir;
    private int x;
    private int y;
    private boolean visible = false;
    private char nom;


    //2. Encapsulation


    public int getEndurance() {
        return endurance+bonusEndurance;
    }

    public int getForce() {
        return force+bonusForce;
    }

    public int getPointDeVie(){
        return pointDeVie;
    }

    public int getPointDeVieActuel() {
        return pointDeVieActuel;
    }

    public void setPointDeVieActuel(int pointDeVieActuel) {
        this.pointDeVieActuel = pointDeVieActuel;
    }

    public int getOr() {
        return or;
    }

    public int getCuir() {
        return cuir;
    }

    public void setOr(int or) {
        this.or += or;
    }

    public void setCuir(int cuir) {
        this.cuir += cuir;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public char getNom() {
        return nom;
    }


    //3. Constructeur

    public Personnage(int bonusForce, int bonusEndurance, char nom, int or, int cuir) {
        this.endurance = Tools.best3Of4();
        this.force = Tools.best3Of4();
        this.bonusForce = bonusForce;
        this.bonusEndurance = bonusEndurance;
        this.pointDeVie = getEndurance() +modificateur(getEndurance());
        this.pointDeVieActuel = this.pointDeVie;
        this.or = or;
        this.cuir = cuir;
        this.nom = nom;
    }

    //4. Méthodes

    public int modificateur (int caracteristique){
        int modif;
        if(caracteristique<5)
            modif = -1;
        else if (caracteristique<10)
            modif = 0;
        else if (caracteristique<15)
            modif = 1;
        else
            modif = 2;

        return modif;
    }

    public void frappe(Personnage ennemi){
        if(ennemi.pointDeVieActuel >0 && this.pointDeVieActuel >0){
            int degats = Tools.D4.lancer();
            degats += this.modificateur(this.getForce());
            ennemi.pointDeVieActuel -= degats;

            System.out.println(this.nom+" attaque:");
            System.out.print(this.getNom() + ": ");
            System.out.println(this.pointDeVieActuel + "PV");
            System.out.print(ennemi.getNom() + ": ");
            System.out.println(ennemi.pointDeVieActuel + "PV");
        }

    }

    public int ennemiAutour (Personnage[][] jeu, int posX, int posY){

        int ennemiAutour = 0;

        if (jeu[posX+1][posY]!=null && jeu[posX+1][posY].pointDeVieActuel>0){
            jeu[posX+1][posY].setVisible(true);
            ennemiAutour = 1;
        } else if (jeu[posX-1][posY]!=null && jeu[posX-1][posY].pointDeVieActuel>0){
            jeu[posX-1][posY].setVisible(true);
            ennemiAutour = 2;
        } else if (jeu[posX][posY+1]!=null && jeu[posX][posY+1].pointDeVieActuel>0){
            jeu[posX][posY+1].setVisible(true);
            ennemiAutour = 3;
        } else if (jeu[posX][posY-1]!=null && jeu[posX][posY-1].pointDeVieActuel>0){
            jeu[posX][posY-1].setVisible(true);
            ennemiAutour = 4;
        }

        return ennemiAutour;
    }

}
