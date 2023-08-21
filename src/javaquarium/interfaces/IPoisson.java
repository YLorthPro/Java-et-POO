package javaquarium.interfaces;

import javaquarium.enums.Sexe;

public interface IPoisson extends IEtreVivant {
    Sexe getSexe();
    void setSexe(Sexe s);
    String getName();
    IPoisson reproduce(IPoisson poisson);
}
