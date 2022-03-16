package creditcard.controllers;


import creditcard.factory.CreditCardFactory;
import creditcard.service.CreditCardAccountServiceImpl;
import framework.enums.AccountType;
import framework.enums.CreditCardType;
import framework.interfaces.Controller;
import framework.models.*;

import java.time.LocalDate;
import java.util.Collection;

public class CreditAccountController implements Controller {
    CreditCardAccountServiceImpl accountService;

    public CreditAccountController() {
        accountService = new CreditCardAccountServiceImpl();
    }

    public Account createCreditCardAccount(String ccn, String name, Address address, String email, LocalDate dob, AccountType accountType, CreditCardType cardType) {
        Customer person = new Person(ccn, name, address, email, dob);
        Account account = CreditCardFactory.createCredCard(cardType, ccn, person);

        return accountService.createAccount(account, person);
    }


    public void deposit(String accountNumber, double amount, String description) {
        accountService.deposit(accountNumber, amount, description);
    }


    public void withdraw(String accountNumber, double amount) {
        accountService.withdraw(accountNumber, amount);
    }

    public Collection<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    public Account getAccountById(String accountId) {
        return accountService.getAccountById(accountId);
    }


    public double getMinimumPayment(String accountNumber) {
        return accountService.getMinimumPayment(accountNumber);
    }

    public Collection<AccountEntry> getMonthlyBilling(String accountNumber) {
        return accountService.getMonthlyBilling(accountNumber);
    }

    @Override
    public void addInterest() {

    }

}
