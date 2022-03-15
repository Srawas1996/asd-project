package framework.observers;

import framework.models.Customer;
import framework.notification.email.EmailMessage;
import framework.notification.email.SendEmailNotification;
import framework.observer.Observer;

public class CustomerCreateObserver implements Observer<Customer> {

    @Override
    public void update(Customer o) {
        EmailMessage message = new EmailMessage(o.getEmail(),"Account Created","Account Created for: "+o.getName());
        (new SendEmailNotification(message)).send();
    }
}
