package banking.strategy.company;

import framework.models.Account;
import framework.models.AccountEntry;
import framework.notification.email.EmailMessage;
import framework.notification.email.SendEmailNotification;
import framework.strategy.TransactionAlertStrategy;

public class CompanyTransactionStrategy implements TransactionAlertStrategy {


    @Override
    public void checkForAlert(Object o) {
        if(o instanceof AccountEntry){
            EmailMessage message = new EmailMessage(((AccountEntry)o).getAccount().getCustomer().getEmail(),
                    "Company Account Transaction","Company Account >> Deposit on account#: "
                    + ((AccountEntry)o).getAccount().getId() + ", amount: " + ((AccountEntry)o).getAmount());
            (new SendEmailNotification(message)).send();
        }
        else{
            if(((Account)o).getBalance() < 0){
                EmailMessage message = new EmailMessage(((Account)o).getCustomer().getEmail(),
                        "Account Balance","Company Account >> Balance issued on account#: " + ((Account)o).getId() + ", balance: " + ((Account)o).getBalance());
                (new SendEmailNotification(message)).send();
            }
        }
    }
}
