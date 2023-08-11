package lambda;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Lambda {
    public static void main (String [] args) {

        int [] tab = {1, 24, -22563, 12349, -38, 56, -3236 } ;
        System.out.print ("-- Les nombres impairs de tab : ") ;
        affichage(tab, elements -> elements%2 != 0) ;

        System.out.print ("-- Les positifs de tab : ") ;
        affichage (tab, e -> e > 0) ;

        System.out.print ("-- Les négatifs de tab : ") ;
        affichage (tab, e -> e < 0) ;

        System.out.print ("-- Les pairs de tab : ") ;
        affichage (tab, e -> e%2 == 0) ;

        System.out.print ("-- Les carrés de tab : ") ;
        afficherCarre (tab, e -> e*e); ;
    }

    public static void affichage (int [] tab, Predicate<Integer> f){
        for (int val : tab){
            if (f.test(val))
                System.out.print (val + " * ") ;
        }
            System.out.println() ;
    }

    public static void afficherCarre(int[] tab, UnaryOperator<Integer> f){
        for (int i : tab) {
            System.out.print(f.apply(i)+" * ");
        }
    }

}
