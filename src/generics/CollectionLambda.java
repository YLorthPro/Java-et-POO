package generics;

public class CollectionLambda <T>{
    private T[] array;
    private int size;

    public CollectionLambda(int size){
        array = (T[]) new Object[size];
    }

    public void add (T element){
        if(size< array.length){
            array[size] = element;
            size++;
        }
    }

    public void afficherElement(){
        for (T t : array) {
            System.out.println(t);
        }
    }

}
