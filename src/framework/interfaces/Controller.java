package framework.interfaces;

import framework.enums.AccountType;
import framework.enums.CreditCardType;
import framework.enums.CustomerType;
import framework.models.Account;
import framework.models.AccountEntry;
import framework.models.Address;

import java.time.LocalDate;
import java.util.Collection;

public interface  Controller {

    public  void deposit(String accountNumber, double amount,String description);

    public  void withdraw(String accountNumber, double amount);

    public Collection<Account> getAllAccounts();

    public  Account getAccountById(String accountId);

    default public double getMinimumPayment(String accountNumber) {
        throw new UnsupportedOperationException();
    }

    default public Collection<AccountEntry> getMonthlyBilling(String accountNumber) {
        throw new UnsupportedOperationException();
    }

    default public Account createCreditCardAccount(String cc, String name, Address address, String email, LocalDate dob, AccountType accountType, CreditCardType cardType) {
        throw new UnsupportedOperationException();
    }

    default public Account createBankingAccount(CustomerType customerType, String accountNumber, String name, Address address, String email, LocalDate dob, AccountType accountType, int numberOfEmployees){
        throw new UnsupportedOperationException();
    }

    public void addInterest();




}


