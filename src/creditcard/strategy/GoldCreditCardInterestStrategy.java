package creditcard.strategy;

import framework.strategy.InterestStrategy;

public class GoldCreditCardInterestStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return ((6/100.0)*balance);
    }
}
