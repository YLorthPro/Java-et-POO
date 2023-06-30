package heroesVSmonsters.personnages.monstres;

import heroesVSmonsters.utils.Des;
import heroesVSmonsters.utils.Tools;

public class Loup extends Monstre {

    //3. Constructeur

    public Loup() {
        super(0, 0, 'L',0,Tools.D4.lancer());
    }

}
