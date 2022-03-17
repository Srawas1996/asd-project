package banking.strategy.person;

import framework.models.Account;
import framework.models.AccountEntry;
import framework.notification.email.EmailMessage;
import framework.notification.email.SendEmailNotification;
import framework.strategy.TransactionAlertStrategy;

public class PersonTransactionStrategy implements TransactionAlertStrategy {


    @Override
    public void checkForAlert(Object o) {
        if(o instanceof AccountEntry){
            if(Math.abs(((AccountEntry)o).getAmount()) > 500  ){

                EmailMessage message = new EmailMessage(
                        ((AccountEntry)o).getAccount().getCustomer().getEmail(),
                        "Account Transaction",
                         " Personal Account >> "+((AccountEntry)o).getDescription()+" Transaction: "
                                + ((AccountEntry)o).getAccount().getId() + ", amount: " + ((AccountEntry)o).getAmount());
                (new SendEmailNotification(message)).send();
            }
        }
        else{
            if(((Account)o).getBalance() < 0) {
                EmailMessage message = new EmailMessage(((Account)o).getCustomer().getEmail(),
                        "Account Balance", "Personal Account >> Balance issued on account#: " + ((Account)o).getId()
                        + ", balance: " + ((Account)o).getBalance());
                (new SendEmailNotification(message)).send();
            }
        }
    }
}
