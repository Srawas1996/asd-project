package creditcard.service;

import creditcard.models.CreditCard;
import creditcard.strategy.GoldCreditCardInterestStrategy;
import framework.models.Account;
import framework.models.AccountEntry;
import framework.models.Customer;
import framework.observers.AccountEntryObserver;
import framework.observers.AccountUpdateObserver;
import framework.repositories.AccountEntryRepository;
import framework.repositories.AccountRepository;
import framework.repositories.CustomerRepository;
import framework.services.AccountService;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.stream.Collectors;


public class CreditCardAccountServiceImpl implements AccountService {

    AccountRepository accountRepository;
    CustomerRepository customerRepository;
    AccountEntryRepository accountEntryRepository;

    private static CreditCardAccountServiceImpl instance = null;

    public static CreditCardAccountServiceImpl getInstance(){
        if (instance == null){
            instance = new CreditCardAccountServiceImpl();
        }
            return instance;
    }

    private CreditCardAccountServiceImpl() {
        accountRepository = new AccountRepository();
        //accountRepository.addObserver(new AccountUpdateObserver());
        customerRepository = new CustomerRepository();
        accountEntryRepository = new AccountEntryRepository();
        accountEntryRepository.addObserver(new AccountEntryObserver());
    }

    @Override
    public Account accountSaved(Account account, Customer customer) {
        Customer dbCustomer = customerRepository.loadOne(customer.getId());
        if (dbCustomer == null) {
            customerRepository.save(customer);
        } else {
            customer = dbCustomer;
        }
        account.setCustomer(customer);
        account.setInterestStrategy(new GoldCreditCardInterestStrategy());
        accountRepository.save(account);
        return account;
    }

    @Override
    public void deposit(String accountNumber, double amount, String description) {
        Account account = accountRepository.loadOne(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException();
        }

        AccountEntry entry = new AccountEntry(-amount, "Deposit", accountNumber);
        entry.setAccount(account);
        accountEntryRepository.save(entry);
        account.addEntry(entry);
        accountRepository.update(account);
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        Account account = accountRepository.loadOne(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException();
        }

        AccountEntry entry = new AccountEntry(amount, "Withdraw", accountNumber);
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
        for (Account account : this.accountRepository.getAll()) {
            account.setInterestStrategy(account.getInterestStrategy());
        }
    }


    public double getMinimumPayment(String accountNumber) {
        CreditCard account = (CreditCard) accountRepository.loadOne(accountNumber);
        double balance = account.getBalance();

        // the user doesn't have to pay
        if (balance < 0) {
            return 0;
        }
        return account.getMinPaymentStrategy().calculateInterest(balance);
    }

    public Collection<AccountEntry> getMonthlyBilling(String accountNumber) {
        CreditCard account = (CreditCard) accountRepository.loadOne(accountNumber);
        LocalDate lastMonth = LocalDate.now().minusMonths(1);
        return account.getEntryList().stream().filter(accountEntry ->
                        Period.between(accountEntry.getDate(), lastMonth).getDays() <= 30)
                .collect(Collectors.toList());
    }
}
