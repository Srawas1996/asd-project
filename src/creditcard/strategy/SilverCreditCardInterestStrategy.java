package creditcard.strategy;

import framework.strategy.InterestStrategy;

public class SilverCreditCardInterestStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return ((8/100.0)*balance);
    }
}
