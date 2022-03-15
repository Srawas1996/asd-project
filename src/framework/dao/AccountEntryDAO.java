package framework.dao;

import framework.models.AccountEntry;
import framework.storage.DAO;
import framework.storage.MemoryStorage;
import framework.storage.Storage;


public class AccountEntryDAO extends DAO<AccountEntry,String> {
    @Override
    public Storage<AccountEntry, String> createStorageFactory() {
        return new MemoryStorage<AccountEntry,String>();
    }
}
