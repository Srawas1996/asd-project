package creditcard.models;

import creditcard.strategy.GoldCreditCardInterestStrategy;
import framework.models.Customer;

public class GoldCreditCard extends CreditCard {
    public GoldCreditCard(String id, Customer customer) {
        super(id, customer);
        this.setInterestStrategy(new GoldCreditCardInterestStrategy());
    }
}
