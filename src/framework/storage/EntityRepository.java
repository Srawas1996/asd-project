package framework.storage;

import framework.observer.Observable;
import framework.observer.Observer;

import java.util.*;

public abstract class EntityRepository<O extends Storable<K>,K> implements Observable<O> {
    DAO<O,K> dao;
    List<Observer> observersList = new ArrayList<>();

    public List<Observer> getObserversList(){
        return observersList;
    }

    public EntityRepository(){
        this.dao = getDao();
    }

    public abstract DAO<O,K> getDao();

    @Override
    public void notify(O obj ){
        for(Observer observer : observersList){
            observer.update(obj);
        }
    }

    public final void save(O obj){
        this.dao.create(obj);
        notify(obj);
    }

    public final void update(O obj){
        this.dao.update(obj);
        notify(obj);
    }

    public final O loadOne(K k){
        O obj = this.dao.loadOne( k);
        notify(obj);
        return obj;
    }

    public final Collection<O> getAll(){
        return this.dao.getAll();
    }

}

