package framework.dao;

import framework.models.Customer;
import framework.storage.DAO;
import framework.storage.MemoryStorage;
import framework.storage.Storage;

public class CustomerDAO extends DAO<Customer,String> {
    @Override
    public Storage<Customer, String> createStorageFactory() {
        return new MemoryStorage<Customer,String>();
    }
}
