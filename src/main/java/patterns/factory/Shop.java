package patterns.factory;

/**
 * Created by Arkadiusz.Ptak on 17.07.2018.
 */
public class Shop extends Webside {
    @Override
    public void createWebside() {
        pages.add(new ContactPage());
        pages.add(new ItemPage());
    }
}
