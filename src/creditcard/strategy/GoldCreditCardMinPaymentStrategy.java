package creditcard.strategy;

import framework.strategy.InterestStrategy;

public class GoldCreditCardMinPaymentStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return ((10/100.0)*balance);
    }
}
