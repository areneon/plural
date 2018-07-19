package patterns.abstractFactory;

/**
 * Created by Arkadiusz.Ptak on 19.07.2018.
 */
public class MasterCardAbstractFactory extends CreditCardAbstractFactory {
    @Override
    public CreditCard getCreditCard(CardType cardType) {
        switch (cardType){
            case GOLD:
                return new MasterCardGold();
            case PLATINUM:
                return new MasterCardPlatinum();
            default:
                break;
        }
        return null;
    }

    @Override
    public CardValidator getValidator(CardType cardType) {
        return null;
    }
}
