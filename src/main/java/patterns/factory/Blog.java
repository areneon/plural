package patterns.factory;

/**
 * Created by Arkadiusz.Ptak on 17.07.2018.
 */
public class Blog extends Webside {
    @Override
    public void createWebside() {
        pages.add(new CartPage());
        pages.add(new ContactPage());
    }
}
