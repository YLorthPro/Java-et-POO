package heroesVSmonsters;

import heroesVSmonsters.personnages.*;
import heroesVSmonsters.personnages.heros.*;
import heroesVSmonsters.personnages.monstres.*;
import heroesVSmonsters.utils.Tools;

import java.util.ArrayList;
import java.util.List;


public class Jeu{

    private final List<Personnage> listeMonstres = new ArrayList<>();
    private final List<Personnage> listeHeros = new ArrayList<>();

    public final String ROUGE = "\u001B[31m";
    public final String VERT = "\u001B[32m";
    public final String ANSI_RESET = "\u001B[0m";


    private void affichage(Personnage[][] jeu, List<Personnage> listeHero){


        System.out.println("-------------------------------------------------------------");
        for (Personnage hero : listeHero) {
            System.out.println(hero.getNom() + " | Or: " + hero.getOr());
            System.out.println("    Cuir: " + hero.getCuir());
        }

        for (int j = 2; j< jeu.length-2; j++){
            System.out.println("-------------------------------------------------------------");
            for (int i=2; i<jeu.length-2; i++){
                if(jeu[i][j]!=null&&!(jeu[i][j].getPointDeVieActuel()>0))
                    System.out.print("| X ");
                else if(jeu[i][j]==null||!jeu[i][j].isVisible())
                    System.out.print("|   ");
                else
                    System.out.print("| " + jeu[i][j].getNom() +" ");
            }
            System.out.println("|");
        }
        System.out.println("-------------------------------------------------------------");

    }

    private void seDeplacer(Hero hero, Personnage[][] jeu){

        //se déplacer

        boolean jouer;
        int deplacementU;

        do {

            affichage(jeu, listeHeros);

            System.out.println("Où voulez vous vous déplacer? 1. droite, 2. gauche, 3. haut, 4. bas");
            deplacementU= Tools.demanderNB(1,4, ROUGE, ANSI_RESET);

            switch(deplacementU){
                case 1: if(hero.getX()==16 || (jeu[hero.getX()+1][hero.getY()]!=null && !(jeu[hero.getX()+1][hero.getY()].getPointDeVieActuel()>0)))
                    System.out.println(ROUGE + "déplacement non permis" + ANSI_RESET);
                else{
                    jeu[hero.getX()][hero.getY()]=null;
                    hero.setX(hero.getX()+1);
                    jeu[hero.getX()][hero.getY()]= hero;
                }
                    break;

                case 2: if(hero.getX()==2 || (jeu[hero.getX()-1][hero.getY()]!=null && !(jeu[hero.getX()-1][hero.getY()].getPointDeVieActuel()>0)))
                    System.out.println(ROUGE + "déplacement non permis" + ANSI_RESET);
                else{
                    jeu[hero.getX()][hero.getY()]=null;
                    hero.setX(hero.getX()-1);
                    jeu[hero.getX()][hero.getY()]= hero;
                }
                    break;

                case 3: if(hero.getY()==2 || (jeu[hero.getX()][hero.getY()-1]!=null && !(jeu[hero.getX()][hero.getY()-1].getPointDeVieActuel()>0)))
                    System.out.println(ROUGE+"déplacement non permis"+ANSI_RESET);
                else{
                    jeu[hero.getX()][hero.getY()]=null;
                    hero.setY(hero.getY()-1);
                    jeu[hero.getX()][hero.getY()]= hero;
                }
                    break;

                case 4: if(hero.getY()==16 || (jeu[hero.getX()][hero.getY()+1]!=null && !(jeu[hero.getX()][hero.getY()+1].getPointDeVieActuel()>0)))
                    System.out.println(ROUGE+"déplacement non permis"+ANSI_RESET);
                else{
                    jeu[hero.getX()][hero.getY()]=null;
                    hero.setY(hero.getY()+1);
                    jeu[hero.getX()][hero.getY()]= hero;
                }
                    break;

                default:
                    System.out.println(ROUGE+"Déplacement non permis"+ANSI_RESET);
                    break;
            }


            //Combat

            if(hero.ennemiAutour(jeu, hero.getX(), hero.getY())>0) {
                System.out.println("Ennemi à proximité");

                affichage(jeu, listeHeros);


                switch (hero.ennemiAutour(jeu, hero.getX(), hero.getY())) {
                    case 1:
                        combat(jeu,hero,1,0);
                        break;

                    case 2:
                        combat(jeu,hero,-1,0);
                        break;

                    case 3:
                        combat(jeu,hero,0,1);
                        break;

                    case 4:
                        combat(jeu,hero,0,-1);
                        break;

                    default:
                        System.out.println("Pas possible");
                        break;
                }
            }else
                System.out.println("C'est calme par ici...");



            System.out.println("Se déplacer avec le même personnage?");
            jouer= Tools.ouiOuNon();
            if(jouer && hero.getPointDeVieActuel()<=0){
                System.out.println(ROUGE + "Ce héros est mort!" + ANSI_RESET);
                jouer=false;
            }

        }while(jouer);


    }

    private void combat(Personnage[][] jeu, Hero hero , int posEnnemiX, int posEnnemiY){
        do {
            hero.frappe(jeu[hero.getX() + posEnnemiX][hero.getY()+posEnnemiY]);
            if (jeu[hero.getX() + posEnnemiX][hero.getY()+posEnnemiY].getPointDeVieActuel() <= 0) {
                System.out.println("Vous avez gagné!");
                break;
            } else
                jeu[hero.getX() + posEnnemiX][hero.getY()+posEnnemiY].frappe(hero);

            if (hero.getPointDeVieActuel() <= 0) {
                System.out.println("Vous avez perdu!");
            }
        } while (hero.getPointDeVieActuel()>0 && jeu[hero.getX() + posEnnemiX][hero.getY()+posEnnemiY].getPointDeVieActuel()>0);
    }

    private void positionnementDepart (Personnage[][] jeu, Personnage p) {
        boolean repeat = true;
        int tempX;
        int tempY;
        do {

            tempX = (int) (Math.random() * (15)+2);
            tempY = (int) (Math.random() * (15)+2);

            //Vérification si case déja prise (2 cases de distance)

            if (jeu[tempX][tempY] == null && jeu[tempX + 1][tempY] == null && jeu[tempX + 2][tempY] == null && jeu[tempX][tempY + 1] == null && jeu[tempX][tempY + 2] == null && jeu[tempX - 1][tempY] == null && jeu[tempX - 2][tempY] == null && jeu[tempX][tempY-1] == null && jeu[tempX][tempY-2] == null) {
                p.setX(tempX);
                p.setY(tempY);
                jeu[tempX][tempY]=p;
                repeat = false;
            }
        } while (repeat);

    }

    private boolean areAlive(List<Personnage> liste){
        for (Personnage personnage : liste) {
            if(personnage.getPointDeVieActuel()>0)
                return true;
        }
        return false;
    }

    public void jeu() {

        //Jouer avec les couleurs


        //initialisation plateau
        final int TAILLE = 19;
        Personnage[][] jeu = new Personnage[TAILLE][TAILLE];
        for (int i = 0; i<TAILLE; i++){
            for (int j=0; j<TAILLE; j++){
                jeu[i][j]=null;
            }
        }

        //Intégration des personnages

        final int nbLoups = 3;
        final int nbOrques = 4;
        final int nbDragonnets = 3;
        final int nbHumains = 1;
        final int nbNains = 1;

        for (int i = 0; i < nbLoups; i++) {
            Loup l = new Loup();
            positionnementDepart(jeu,l);
            listeMonstres.add(l);
        }
        for (int i = 0; i < nbOrques; i++) {
            Orque o = new Orque();
            positionnementDepart(jeu,o);
            listeMonstres.add(o);
        }
        for (int i = 0; i < nbDragonnets; i++) {
            Dragonnet d = new Dragonnet();
            positionnementDepart(jeu,d);
            listeMonstres.add(d);
        }
        for (int i = 0; i < nbHumains; i++) {
            Humain h = new Humain();
            positionnementDepart(jeu,h);
            listeHeros.add(h);
        }
        for (int i = 0; i < nbNains; i++) {
            Nain n = new Nain();
            positionnementDepart(jeu,n);
            listeHeros.add(n);
        }

        affichage(jeu,listeHeros);

        boolean repeterJeu;

        do {

            System.out.println("Avec qui voulez vous jouer?");
            System.out.println("1. Humain, 2. Nain");
            switch(Tools.demanderNB(1,2, ROUGE, ANSI_RESET)){
                case 1: if(listeHeros.get(0).getPointDeVieActuel()>0) {
                            seDeplacer((Hero) listeHeros.get(0),jeu);
                        } else {
                             System.out.println(ROUGE+"Ce héro est mort"+ANSI_RESET);
                        }
                        break;
                case 2: if(listeHeros.get(1).getPointDeVieActuel()>0) {
                            seDeplacer((Hero) listeHeros.get(1), jeu);
                        } else {
                            System.out.println(ROUGE+"Ce héro est mort"+ANSI_RESET);
                        }
                        break;
                default:
                    System.out.println(ROUGE+"Moi pas comprendre!"+ANSI_RESET);
                    break;
            }

            if(areAlive(listeHeros)&&areAlive(listeMonstres)){
                System.out.println("Voulez vous encore jouer?");
                repeterJeu= Tools.ouiOuNon();
            }else if(areAlive(listeHeros)){
                System.out.println(VERT +"Vous avez gagné!"+ANSI_RESET);
                repeterJeu=false;
            } else {
                System.out.println(ROUGE +"Vous avez perdu!"+ANSI_RESET);
                repeterJeu=false;
            }
        }while (repeterJeu);

        System.out.println("Fin de partie!");

    }
}