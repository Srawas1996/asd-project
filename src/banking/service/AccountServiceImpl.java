package banking.service;

import banking.strategy.BasicAccountInterestStrategy;
import framework.models.Account;
import framework.models.AccountEntry;
import framework.models.Customer;
import framework.observers.AccountEntryObserver;
import framework.observers.AccountUpdateObserver;
import framework.repositories.AccountEntryRepository;
import framework.repositories.AccountRepository;
import framework.repositories.CustomerRepository;
import framework.services.AccountService;
import framework.storage.RepositoryEvents;

import java.util.Collection;


public class AccountServiceImpl implements AccountService {

	AccountRepository accountRepository;
	CustomerRepository customerRepository;
	AccountEntryRepository accountEntryRepository;

	// Singleton instance
	private static AccountServiceImpl instance;

	public static AccountServiceImpl getInstance() {
		if (instance == null) {
			instance = new AccountServiceImpl();
		}
		return instance;
	}

	public AccountServiceImpl(){
		accountRepository = new AccountRepository();
		accountRepository.addObserver(new AccountUpdateObserver(), RepositoryEvents.POST_UPDATE);
		customerRepository = new CustomerRepository();
		accountEntryRepository = new AccountEntryRepository();
		accountEntryRepository.addObserver(new AccountEntryObserver(),RepositoryEvents.POST_SAVE);
	}

	@Override
	public Account createAccount(Account account, Customer customer) {
		Customer dbCustomer = customerRepository.loadOne(customer.getId());
		if(dbCustomer == null){
			customerRepository.save(customer);
		}else{
			customer = dbCustomer;
		}
		account.setCustomer(customer);
		account.setInterestStrategy(new BasicAccountInterestStrategy());
		accountRepository.save(account);
		return account;
	}

	@Override
	public void deposit(String accountNumber, double amount,String description) {
		Account account = accountRepository.loadOne(accountNumber);
		if(account == null){
			throw new IllegalArgumentException();
		}

		AccountEntry entry = new AccountEntry(amount, description, accountNumber, "");
		entry.setAccount(account);
		accountEntryRepository.save(entry);
		account.addEntry(entry);
		accountRepository.update(account);
	}

	@Override
	public void withdraw(String accountNumber, double amount) {
		Account account = accountRepository.loadOne(accountNumber);
		if(account == null){
			throw new IllegalArgumentException();
		}

		AccountEntry entry = new AccountEntry(-amount, "Withdraw", accountNumber, "");
		entry.setAccount(account);
		accountEntryRepository.save(entry);
		account.addEntry(entry);
		accountRepository.update(account);
	}

	@Override
	public Collection<Account> getAllAccounts() {
		return this.accountRepository.getAll();
	}

	@Override
	public Account getAccountById(String accountId) {
		return this.accountRepository.loadOne(accountId);
	}

	@Override
	public void setInterest() {
		for(Account account: this.accountRepository.getAll()){
			this.deposit(account.getId(),account.getInterestStrategy().calculateInterest(account.getBalance()),"interest");
		}
	}


}
