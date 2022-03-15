package framework.repositories;

import framework.dao.CustomerDAO;
import framework.models.Customer;
import framework.observer.Observer;
import framework.observers.CustomerCreateObserver;
import framework.storage.DAO;
import framework.storage.EntityRepository;
import framework.storage.RepositoryEvents;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CustomerRepository extends EntityRepository<Customer,String> {

    @Override
    public DAO<Customer, String> getDao() {
        return new CustomerDAO();
    }

    public Map<RepositoryEvents, Set<Observer>> actionListeners(){
        Map observers =  new HashMap<RepositoryEvents, Set<Observer>>();
        observers.put(RepositoryEvents.POST_SAVE,new CustomerCreateObserver());
        return observers;
    }
}
