package framework.observer;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public interface Observable<EventType extends framework.interfaces.EventType,T> {

    Map<framework.interfaces.EventType, Set<Observer>> getObserversList();

    default void addObserver(Observer observer, EventType repositoryEvents){
        Set<Observer> observers;

        if(getObserversList().containsKey(repositoryEvents)){
            observers = getObserversList().get(repositoryEvents);
        }

        else{
            observers = new HashSet<>();
            getObserversList().put(repositoryEvents, observers);
        }
        observers.add(observer);
    }


    void notify(EventType event,T obj);

}
