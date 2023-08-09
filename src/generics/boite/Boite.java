package generics.boite;

import java.util.ArrayList;
import java.util.List;

public class Boite <C>{

    private final List<C> contenu = new ArrayList<>();

    public void add(C chose){
        if(chose == null)
            throw new IllegalArgumentException("Ne peut être null");

        contenu.add(chose);
    }

    public void afficherContenu(){
        System.out.println("------------------------------ Contenu--------------------------");
        for (C c : contenu) {
            System.out.println(c);
        }
        System.out.println("------------------------------------------------------------");
    }

}
