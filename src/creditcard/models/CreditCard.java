package creditcard.models;


import creditcard.strategy.NoCreditCardMinPaymentStrategy;
import framework.enums.AccountType;
import framework.models.Account;
import framework.models.Customer;
import framework.strategy.InterestStrategy;

public abstract class CreditCard extends Account {

    private InterestStrategy minPaymentStrategy;

    public CreditCard(String id, Customer customer) {
        super(id, customer, AccountType.CREDIT);
        this.minPaymentStrategy = new NoCreditCardMinPaymentStrategy();
    }

    public InterestStrategy getMinPaymentStrategy() {
        return minPaymentStrategy;
    }

    public void setMinPaymentStrategy(InterestStrategy minPaymentStrategy) {
        this.minPaymentStrategy = minPaymentStrategy;
    }
}
