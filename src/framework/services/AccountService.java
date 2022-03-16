package framework.services;

import framework.models.Account;
import framework.models.Customer;

import java.util.Collection;

public interface AccountService {
    Account accountSaved(Account account, Customer customer);
    void deposit(String accountNumber, double amount,String description);
    void withdraw(String accountNumber, double amount);
    Collection<Account> getAllAccounts();
    Account getAccountById(String accountId);
    void setInterest();
}
