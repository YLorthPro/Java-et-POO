package lambda;

public class Lambda {
    public static void main (String [] args) {

        int [] tab = {1, 24, -22563, 12349, -38, 56, -3236 } ;
        System.out.print ("-- Les nombres impairs de tab : ") ;
        affichage(tab, elements -> elements%2 != 0) ;
    }

    public static void affichage (int [] tab, Filtre f){
        for (int val : tab){
            if (f.isImpair (val))
                System.out.print (val + " * ") ;
        }
            System.out.println() ;
    }

}
