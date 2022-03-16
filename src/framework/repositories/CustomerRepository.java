package framework.repositories;

import framework.dao.CustomerDAO;
import framework.models.Customer;
import framework.storage.DAO;
import framework.storage.EntityRepository;

public class CustomerRepository extends EntityRepository<Customer,String> {

    @Override
    public DAO<Customer, String> getDao() {
        return new CustomerDAO();
    }

}
