package stream;

import java.util.Arrays;

public class Stream {
    public static void main(String[] args) {

        int [] tab = {1, 24, -22563, 12349, -38, 56, -3236 } ;

        Arrays.stream(tab).map(element -> element*element)
                .forEach(element -> System.out.println(element));

        //Positif

        //Négatif

        //Pair

        //Impair

        //Double

    }
}
