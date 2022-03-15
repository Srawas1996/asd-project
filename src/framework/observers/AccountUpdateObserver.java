package framework.observers;

import framework.models.Account;
import framework.observer.Observer;


public class AccountUpdateObserver implements Observer<Account> {
    @Override
    public void update(Account o) {
        if(o.getCustomer().getTransactionStrategy() !=null){
            o.getCustomer().getTransactionStrategy().checkForAlert(o);
        }
    }
}
