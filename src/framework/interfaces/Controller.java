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

      void deposit(String accountNumber, double amount,String description);

      void withdraw(String accountNumber, double amount);

     Collection<Account> getAllAccounts();

      Account getAccountById(String accountId);

    default  double getMinimumPayment(String accountNumber) {
        throw new UnsupportedOperationException();
    }

    default  Collection<AccountEntry> getMonthlyBilling(String accountNumber) {
        throw new UnsupportedOperationException();
    }

    default  Account createCreditCardAccount(String cc, String name, Address address, String email, LocalDate dob, AccountType accountType, CreditCardType cardType) {
        throw new UnsupportedOperationException();
    }

    default  Account createBankingAccount(CustomerType customerType, String accountNumber, String name, Address address, String email, LocalDate dob, AccountType accountType, int numberOfEmployees){
        throw new UnsupportedOperationException();
    }

     void addInterest();




}


