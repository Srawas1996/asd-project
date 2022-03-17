package framework.observer;

import java.util.*;

public interface Observable<T> {

    List<Observer> getObserversList();

    default void addObserver(Observer observer){
        List<Observer> observers = getObserversList();
        observers.add(observer);
    }


    void notify(T obj);

}
