package javaquarium.models;

import javaquarium.enums.Sexe;
import javaquarium.interfaces.IPoisson;

import java.util.Random;

public abstract class Poisson extends EtreVivant implements IPoisson {
    private Sexe sexe;
    private String name;

    public Poisson(String name) {
        Random rand = new Random();

        this.setHP(10);
        this.name = name;
        this.sexe = Sexe.values()[rand.nextInt(Sexe.values().length)];
    }



    @Override
    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public abstract IPoisson reproduce(IPoisson poisson);

    public boolean aFaim() {
        return this.getHP() < 6;
    }

    @Override
    public void passerTour() {
        this.setHP(this.getHP() - 1);
        this.setAge(this.getAge() + 1);
    }

    @Override
    public String toString() {
        return String.format("Poisson %s, %s, %s pv", this.name, this.sexe.toString(), this.getHP());
    }
}
