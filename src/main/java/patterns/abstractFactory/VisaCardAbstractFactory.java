package patterns.abstractFactory;

/**
 * Created by Arkadiusz.Ptak on 19.07.2018.
 */
public class VisaCardAbstractFactory extends CreditCardAbstractFactory {
    @Override
    public CreditCard getCreditCard(CardType cardType) {
        switch (cardType){
            case GOLD:
                return new VisarCardGold();
            case PLATINUM:
                return new VisaCardPlatinum();
            default:
                break;
        }
        return null;
    }

    @Override
    public CardValidator getValidator(CardType cardType) {
        switch (cardType){
            case GOLD:
                return new GoldValidator();
            case PLATINUM:
                return new PlatinumValidator();
            default:
                break;
        }
        return null;
    }
}
