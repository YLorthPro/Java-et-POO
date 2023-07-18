package heroesVSmonsters.personnages.monstres;

import heroesVSmonsters.ILootLeather;
import heroesVSmonsters.utils.Tools;

public class Loup extends Monstre implements ILootLeather {

    //3. Constructeur

    public Loup() {
        super(0, 0, 'L',0,Tools.D4.lancer());
    }

    @Override
    public int getCuir() {
        return this.getCuir();
    }
}
