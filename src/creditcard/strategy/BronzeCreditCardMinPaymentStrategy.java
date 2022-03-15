package creditcard.strategy;

import framework.strategy.InterestStrategy;

public class BronzeCreditCardMinPaymentStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return ((14/100.0)*balance);
    }
}
