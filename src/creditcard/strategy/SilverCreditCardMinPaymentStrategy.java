package creditcard.strategy;

import framework.strategy.InterestStrategy;

public class SilverCreditCardMinPaymentStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return ((12/100.0)*balance);
    }
}
