package creditcard.factory;

import creditcard.strategy.BronzeCreditCardMinPaymentStrategy;
import creditcard.strategy.GoldCreditCardMinPaymentStrategy;
import creditcard.strategy.NoCreditCardMinPaymentStrategy;
import creditcard.strategy.SilverCreditCardMinPaymentStrategy;
import framework.enums.CreditCardType;
import framework.strategy.InterestStrategy;

public class MinPaymentStrategyFactory {
    private static GoldCreditCardMinPaymentStrategy goldCCMinPaymentStrategy;
    private static SilverCreditCardMinPaymentStrategy silverCCMinPaymentStrategy;
    private static BronzeCreditCardMinPaymentStrategy bronzeCCMinPaymentStrategy;
    private static final NoCreditCardMinPaymentStrategy noCCMinPaymentStrategy = new NoCreditCardMinPaymentStrategy();


    public static InterestStrategy getMinPaymentStrategy(CreditCardType cardType) {

        if (cardType == CreditCardType.BRONZE) {
            if(bronzeCCMinPaymentStrategy == null)
                bronzeCCMinPaymentStrategy = new BronzeCreditCardMinPaymentStrategy();

        } else if (cardType == CreditCardType.GOLD) {
            if(goldCCMinPaymentStrategy == null)
                goldCCMinPaymentStrategy = new GoldCreditCardMinPaymentStrategy();
            return goldCCMinPaymentStrategy;
        } else if (cardType == CreditCardType.SILVER) {
            if(silverCCMinPaymentStrategy == null)
                silverCCMinPaymentStrategy = new SilverCreditCardMinPaymentStrategy();
            return silverCCMinPaymentStrategy;
        }

        return noCCMinPaymentStrategy;

    }
}
