package javaquarium.models;

import javaquarium.interfaces.IAlgue;
import javaquarium.interfaces.IHerbivore;

public abstract class Herbivore extends Poisson implements IHerbivore {
    public Herbivore(String name) {
        super(name);
    }

    public void manger(IAlgue algue) {
        if (this.aFaim()) {
            System.out.printf("%s mange une algue", this.getName());
            System.out.println();
            algue.setHP(algue.getHP() - 2);
            this.setHP(this.getHP() + 3);
        }
    }
}
