package heroesVSmonsters.personnages.monstres;

import heroesVSmonsters.personnages.Personnage;

public abstract class Monstre extends Personnage {


    //3. Constructeur

    public Monstre(int bonusForce, int bonusEndurance, char nom,int or, int cuir) {
        super(bonusForce, bonusEndurance,nom,or,cuir);
    }


}
