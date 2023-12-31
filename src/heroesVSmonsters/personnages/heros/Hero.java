package heroesVSmonsters.personnages.heros;

import heroesVSmonsters.ILootGold;
import heroesVSmonsters.ILootLeather;
import heroesVSmonsters.personnages.Personnage;

public abstract class Hero extends Personnage {

    //1. Variables

    //2.Encapsulation

    //3. Constructeur


    public Hero(int bonusForce, int bonusEndurance, char nom) {
        super(bonusForce, bonusEndurance,nom,0,0);
        this.setVisible(true);
    }

    //4. Méthodes

    @Override
    public void frappe(Personnage ennemi) {
        super.frappe(ennemi);
        if (ennemi.getPointDeVieActuel()<=0){
            if(ennemi instanceof ILootGold){
                this.setOr(ennemi.getOr());
                ennemi.setOr(-ennemi.getOr());
            }

            if(ennemi instanceof ILootLeather){
                this.setCuir(ennemi.getCuir());
                ennemi.setCuir(-ennemi.getCuir());
            }

            this.setPointDeVieActuel(this.getPointDeVie());

        }
    }


}
