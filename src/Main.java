import heritage.etresVivants.marin.Baleine;
import heritage.etresVivants.marin.Poisson;
import heritage.etresVivants.marin.terrestre.Chien;
import heritage.etresVivants.marin.terrestre.Serpent;

public class Main {
    public static void main(String[] args) {

        Chien chien = new Chien("Pluto");
        Serpent serpent = new Serpent();
        Poisson poisson = new Poisson(5);
        Baleine baleine = new Baleine(3,1234.56);



    }
}
