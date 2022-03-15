package creditcard.models;

import creditcard.strategy.SilverCreditCardInterestStrategy;
import framework.models.Customer;

public class SilverCreditCard extends CreditCard {
    public SilverCreditCard(String id, Customer customer) {
        super(id, customer);
        this.setInterestStrategy(new SilverCreditCardInterestStrategy());
    }
}
