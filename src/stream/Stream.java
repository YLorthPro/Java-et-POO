package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {

        int [] tab = {1, 24, -22563, 12349, -38, 56, -3236 } ;


        //Carré
        Arrays.stream(tab).map(e->e*e).forEach(System.out::println);

        //Positif
        Arrays.stream(tab).filter(e->e>0).forEach(System.out::println);
        //Negatif
        Arrays.stream(tab).filter(e->e<0).forEach(System.out::println);
        //Pair
        Arrays.stream(tab).filter(e->e%2==0).forEach(System.out::println);
        //Impair
        Arrays.stream(tab).filter(e->e%2!=0).forEach(System.out::println);
        //Double
        Arrays.stream(tab).map(e->e*2).forEach(System.out::println);



        // Manipulation de liste vs stream


        List<Integer> liste = new ArrayList<>();

        for (int i : tab) {
            liste.add(i);
        }

        //Lancera une exception!

//        for (Integer i : liste) {
//            if(i%2 == 0)
//                liste.remove(i);
//        }

        liste = liste.stream().filter(e->e%2 ==0).collect(Collectors.toList());

        System.out.println(liste);
    }
}
