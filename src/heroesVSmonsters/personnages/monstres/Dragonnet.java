package heroesVSmonsters.personnages.monstres;

import heroesVSmonsters.ILootGold;
import heroesVSmonsters.ILootLeather;
import heroesVSmonsters.utils.Tools;

public class Dragonnet extends Monstre implements ILootGold, ILootLeather {

    //1.Variables

    //3. Constructeurs

    public Dragonnet() {
        super(0, 1, 'D',Tools.D6.lancer(),Tools.D4.lancer());
    }


    @Override
    public int getOr() {
        return this.getOr();
    }

    @Override
    public int getCuir() {
        return this.getCuir();
    }
}
