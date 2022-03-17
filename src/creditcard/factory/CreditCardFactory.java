package creditcard.factory;

import creditcard.models.BronzeCreditCard;
import creditcard.models.CreditCard;
import creditcard.models.GoldCreditCard;
import creditcard.models.SilverCreditCard;
import framework.enums.CreditCardType;
import framework.models.Customer;

public class CreditCardFactory {

     static CreditCard creditCard;

    public static CreditCard createCredCard(CreditCardType cardType, String id, Customer customer) {

        if (cardType == CreditCardType.BRONZE) {
            creditCard = new BronzeCreditCard(id, customer);
        } else if (cardType == CreditCardType.GOLD) {
            creditCard = new GoldCreditCard(id, customer);
        } else if (cardType == CreditCardType.SILVER) {
            creditCard = new SilverCreditCard(id, customer);
        }

        creditCard.setMinPaymentStrategy(MinPaymentStrategyFactory.getMinPaymentStrategy(cardType));
        return creditCard;

    }
}
