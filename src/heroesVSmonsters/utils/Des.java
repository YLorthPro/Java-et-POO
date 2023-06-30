package heroesVSmonsters.utils;

public class Des {

    //1. Variables

    private final int min;
    private final int max;

    //2. Encapsulation

    //3. Constructeur

    public Des(int min, int max) {
        this.min = min;
        this.max = max;
    }

    //4. Méthodes

    public int lancer(){
        return min + (int) (Math.random()*(max -min +1));
    }

}

