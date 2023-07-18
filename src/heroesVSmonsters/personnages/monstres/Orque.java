package heroesVSmonsters.personnages.monstres;

import heroesVSmonsters.ILootGold;
import heroesVSmonsters.utils.Tools;

public class Orque extends Monstre implements ILootGold {

    //1.Variables

    //3. Constructeurs

    public Orque() {
        super(1, 0,'O',Tools.D6.lancer(),0);
    }

    @Override
    public int getOr() {
        return this.getOr();
    }
}
