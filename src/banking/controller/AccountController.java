package banking.controller;

import banking.service.AccountServiceImpl;
import framework.enums.AccountType;
import framework.enums.CustomerType;
import framework.interfaces.Controller;
import framework.models.*;
import framework.services.AccountService;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

public class AccountController implements Controller {
    AccountService accountService;

    public AccountController() {
        accountService = AccountServiceImpl.getInstance();
    }

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public Account createBankingAccount(CustomerType customerType, String accountNumber, String name, Address address, String email,
                                        LocalDate dob, AccountType accountType,int numberOfEmployees) {
        Account account = AccountFactory.CreateFactoryAccount(customerType,accountNumber,name,address,email,dob,accountType,numberOfEmployees,accountService);

        return account;
    }

    public void addInterest(){
        accountService.setInterest();
    }

    @Override
    public void deposit(String accountNumber, double amount,String description) {
        accountService.deposit(accountNumber,amount,description);
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        accountService.withdraw(accountNumber,amount);
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @Override
    public Account getAccountById(String accountId) {
        return accountService.getAccountById(accountId);
    }


}
