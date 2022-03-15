package framework.repositories;

import framework.dao.AccountEntryDAO;
import framework.models.AccountEntry;
import framework.storage.DAO;
import framework.storage.EntityRepository;

public class AccountEntryRepository extends EntityRepository<AccountEntry,String> {

    @Override
    public DAO<AccountEntry, String> getDao() {
        return new AccountEntryDAO();
    }

}
