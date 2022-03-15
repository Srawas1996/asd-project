package banking;

import banking.controller.AccountController;
import banking.service.AccountServiceImpl;
import framework.enums.AccountType;
import framework.enums.CustomerType;
import framework.models.*;

import java.time.LocalDate;

public class Main {

    public static void main (String[] args){

        AccountServiceImpl accountService = new AccountServiceImpl();
        AccountController accountController = new AccountController(accountService);


        accountController.createBankingAccount(CustomerType.PERSON,"000001","Same",new Address("1 Pioneer Ranch","Las Vegas","Nevada","98113"),"same@gmail.com", LocalDate.of(1985, 10, 5), AccountType.CHECKING,0);
        accountController.createBankingAccount(CustomerType.PERSON, "000002","Jhone",new Address("2 Burlington","Fairfield","Iowa","52556"),"Jhone@gmail.com", LocalDate.of(1983, 01, 1), AccountType.SAVING, 0);
        accountController.createBankingAccount(CustomerType.COMPANY,"000003","obsa", new Address("3 N 4th St","Ottumwa","Iowa","52559"),"obsa@gmail.com",LocalDate.of(2009,10,1), AccountType.SAVING, 1500);
        accountController.createBankingAccount(CustomerType.COMPANY,"000004","Bobbe",new Address("4 Martin Ave","Des Moines","Iowa","53777"),"Bobbe@gmail.com", LocalDate.of(1990,05,4), AccountType.CHECKING,2500);

        accountController.deposit("000001",1000,"Deposit");
        accountController.withdraw("000001",600);

        accountController.deposit("000002",400,"Deposit");
        accountController.deposit("000003",300,"Deposit");
        accountController.deposit("000003",400,"Deposit");
        accountController.deposit("000004",400,"Deposit");

        accountController.addInterest();

        for (Account account : accountController.getAllAccounts()) {
            Customer customer = account.getCustomer();
            System.out.println("Statement for Account: " + account.getId());
            System.out.println("Account Holder: " + customer.getName());
            System.out.println("Account Type: " + account.getAccountType().toString());

            System.out.println("-AccountNbr------"
                    + "-Name-------------------"
                    + "-City-------------"
                    + "-P/C--------------"
                    + "-Ch/S------------------"
                    + "-Amount---------");

            System.out.printf("%8s%14s %25s%18s%18s%23s\n",
                    account.getId(),
                    customer.getName(),
                    customer.getAddress().getCity(),
                    account.getCustomer().getCustomerType(),
                    account.getAccountType().toString(),
                    account.getBalance());

            System.out.println("----------------------------------------------------------" + "----------------------------------------------------------");

            System.out.println("-Date-------------------------"
                    + "-Description------------------"
                    + "-Amount-------------");

            for (AccountEntry entry : account.getEntryList()) {
                System.out.printf("%8s%30s%28.2f\n",
                        entry.getDate().toString(),
                        entry.getDescription(),
                        entry.getAmount());
            }

            System.out.println("----------------------------------------" + "----------------------------------------");
            System.out.printf("%15s%30s%23.2f\n\n", "", "Current Balance:", account.getBalance());
        }
    }
}
