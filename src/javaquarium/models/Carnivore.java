package javaquarium.models;

import javaquarium.interfaces.ICarnivore;
import javaquarium.interfaces.IPoisson;

public abstract class Carnivore extends Poisson implements ICarnivore {
    public Carnivore(String name) {
        super(name);
    }

    public void manger(IPoisson poisson) {
        if (poisson != this &&
                this.aFaim() &&
                this.getClass() != poisson.getClass()) {
            poisson.setHP(poisson.getHP() - 4);
            this.setHP(this.getHP() + 5);
        }
    }
}
