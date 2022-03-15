package creditcard;

import creditcard.controllers.CreditAccountController;
import framework.enums.AccountType;
import framework.enums.CreditCardType;
import framework.models.Account;
import framework.models.AccountEntry;
import framework.models.Address;

import java.time.LocalDate;
import java.util.Collection;

public class CreditCardApplication {

    public static void main(String[] args) {
        CreditAccountController creditAccountController = new CreditAccountController();
        LocalDate dob = LocalDate.now();
        Account creditAccount = creditAccountController.createAccount("xxxssnxx","Salim", new Address("street", "City", "IA", "52556"), "salim96tr@gmail.com", dob, AccountType.CREDIT, CreditCardType.GOLD);

        creditAccountController.deposit(creditAccount.getId(), 100, "Deposit");
        creditAccountController.deposit(creditAccount.getId(), 500, "Deposit");
        creditAccountController.withdraw(creditAccount.getId(), 1000);
        creditAccount = creditAccountController.getAccountById(creditAccount.getId());
        
        System.out.println("\nCredit Account \n");

        double currentBalance = creditAccount.getBalance();
        System.out.println("Current Balance: " + currentBalance);
        System.out.println("Minimum Payment " + creditAccountController.getMinimumPayment(creditAccount.getId()));
        
        Collection<AccountEntry> accountEntries = creditAccountController.getMonthlyBilling(creditAccount.getId());
        
        for (AccountEntry entry : accountEntries) {
            System.out.println("Description: " + entry.getDescription() + " " + entry.getAmount());
        }
    }

}
