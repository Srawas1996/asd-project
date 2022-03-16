package framework.dao;

import framework.models.Account;
import framework.storage.DAO;
import framework.storage.MemoryStorage;
import framework.storage.Storage;

public class AccountDAO extends DAO<Account,String> {
    @Override
    public Storage<Account, String> createStorageFactory() {
        return new MemoryStorage<>();
    }
}
