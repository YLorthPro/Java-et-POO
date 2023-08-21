package javaquarium.models;

import javaquarium.enums.Sexe;
import javaquarium.interfaces.IHermaphrodite;
import javaquarium.interfaces.IPoisson;

public class Sole extends Herbivore implements IHermaphrodite {
    public Sole(String name) {
        super(name);
    }

    @Override
    public IPoisson reproduce(IPoisson poisson) {
        if (poisson != this
                && poisson instanceof Sole) {
            if (poisson.getSexe() == this.getSexe()) {
                changementSexe();
            }
            return new PoissonClown("Bébé");
        }
        else return null;
    }

    @Override
    public void changementSexe() {
        if(getSexe()==Sexe.MALE){
            setSexe(Sexe.FEMELLE);
        } else
            setSexe(Sexe.MALE);
    }
}
