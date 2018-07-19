package patterns.abstractFactory;

/**
 * Fabryka fabryk
 * dosyc zlozona
 */
public abstract class CreditCardAbstractFactory {
 private static final int MINIMAL_MASTERCARD_SCORE = 650;
    public static CreditCardAbstractFactory getCreditCardFactory(int creditScore){
        if(creditScore >MINIMAL_MASTERCARD_SCORE){
            return new MasterCardAbstractFactory();
        }
        else{
            return new VisaCardAbstractFactory();
        }
    }

    public abstract CreditCard getCreditCard(CardType cardType);

    public abstract CardValidator getValidator(CardType cardType);
}
