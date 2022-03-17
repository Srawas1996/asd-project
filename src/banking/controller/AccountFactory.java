package banking.controller;

import framework.enums.AccountType;
import framework.enums.CustomerType;
import framework.models.*;
import framework.services.AccountService;

import java.time.LocalDate;
import java.util.UUID;

public class AccountFactory {
    public static Account CreateFactoryAccount(CustomerType customerType, String accountNumber, String name, Address address, String email,
                                               LocalDate dob, AccountType accountType, int numberOfEmployees, AccountService accountService){
        UUID uuid = UUID.randomUUID();
        Account account;
        if (customerType.equals(CustomerType.PERSON)) {
            Customer personCustomer = new Person(uuid.toString(), name, address, email, dob);
            account = new Account(accountNumber, personCustomer, accountType);
            return accountService.accountSaved(account, personCustomer);
        } else {
            Customer companyCustomer = new Company(uuid.toString(),name,address,email,numberOfEmployees);
            account = new Account(accountNumber,companyCustomer,accountType);
            return accountService.accountSaved(account,companyCustomer);
        }

    }
}
