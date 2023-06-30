package heroesVSmonsters.personnages.monstres;

import heroesVSmonsters.utils.Des;
import heroesVSmonsters.utils.Tools;

public class Dragonnet extends Monstre {

    //1.Variables

    //3. Constructeurs

    public Dragonnet() {
        super(0, 1, 'D',Tools.D6.lancer(),Tools.D4.lancer());
    }


}
