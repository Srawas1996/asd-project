package creditcard.models;

import creditcard.strategy.BronzeCreditCardInterestStrategy;
import framework.models.Customer;

public class BronzeCreditCard extends CreditCard {
    public BronzeCreditCard(String id, Customer customer) {
        super(id, customer);
        this.setInterestStrategy(new BronzeCreditCardInterestStrategy());
    }
}
