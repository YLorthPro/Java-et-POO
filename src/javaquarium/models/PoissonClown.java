package javaquarium.models;

import javaquarium.enums.Sexe;
import javaquarium.interfaces.IHermaphrodite;
import javaquarium.interfaces.IPoisson;

public class PoissonClown extends Carnivore implements IHermaphrodite {
    public PoissonClown(String name) {
        super(name);
    }

    @Override
    public IPoisson reproduce(IPoisson poisson) {
        if (poisson != this
                && poisson instanceof PoissonClown) {
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
