package pimpedtodolist;

import exception.GeoffreyException;

import java.util.*;

public class TodoList {

    private final LinkedList<Tache> taches = new LinkedList<>();

    public void ajouter(Tache tache){

        if( tache == null )
            throw new IllegalArgumentException();

        switch (tache.getPriorite()){
            case ATTENTION:
                int nbrCodeRouge = 0;
                Iterator<Tache> tacheIterator = taches.iterator();
                while ( tacheIterator.hasNext() && tacheIterator.next().getPriorite().isGreaterThan(Priorite.ATTENTION) ){
                    nbrCodeRouge++;
                }
                taches.add(nbrCodeRouge, tache);
                break;
            case TRANQUILLE:
                taches.addLast(tache);
                break;
            case CODE_ROUGE:
                taches.addFirst(tache);
                break;
            default:
                throw new GeoffreyException("Mais....");
        }

    }

    public Tache checkNext(){
        return taches.peekFirst();
    }

    public Tache executeNext(){
        return taches.pop();
    }


}
