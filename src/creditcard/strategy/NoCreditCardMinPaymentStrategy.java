package creditcard.strategy;

import framework.strategy.InterestStrategy;

public class NoCreditCardMinPaymentStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return (0);
    }
}
