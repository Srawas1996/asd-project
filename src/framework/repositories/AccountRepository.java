package framework.repositories;


import framework.dao.AccountDAO;
import framework.models.Account;
import framework.storage.DAO;
import framework.storage.EntityRepository;

public class AccountRepository extends EntityRepository<Account,String> {

    @Override
    public DAO<Account, String> getDao() {
        return new AccountDAO();
    }

}
