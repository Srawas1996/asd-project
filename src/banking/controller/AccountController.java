package banking.controller;

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

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public Account createBankingAccount(CustomerType customerType, String accountNumber, String name, Address address, String email, LocalDate dob, AccountType accountType,int numberOfEmployees) {

            UUID uuid = UUID.randomUUID();
            Account account;
            if (customerType.equals(CustomerType.PERSON)) {
                Customer personCustomer = new Person(uuid.toString(), name, address, email, dob);
                account = new Account(accountNumber, personCustomer, accountType);
                return accountService.createAccount(account, personCustomer);
            } else {
                Customer companyCustomer = new Company(uuid.toString(),name,address,email,numberOfEmployees);
                account = new Account(accountNumber,companyCustomer,accountType);
                return accountService.createAccount(account,companyCustomer);
            }
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

    @Override
    public double getMinimumPayment(String accountNumber) {
        return Controller.super.getMinimumPayment(accountNumber);
    }

    @Override
    public Collection<AccountEntry> getMonthlyBilling(String accountNumber) {
        return Controller.super.getMonthlyBilling(accountNumber);
    }

}
