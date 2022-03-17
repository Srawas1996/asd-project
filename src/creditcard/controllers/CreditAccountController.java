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
        accountService = CreditCardAccountServiceImpl.getInstance();
    }

    public Account createCreditCardAccount(String creditCardNumber, String name, Address address, String email, LocalDate dateOfBirth, AccountType accountType, CreditCardType cardType) {
        Customer person = new Person(creditCardNumber, name, address, email, dateOfBirth);
        Account account = CreditCardFactory.createCredCard(cardType, creditCardNumber, person);

        return accountService.accountSaved(account, person);
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

}
