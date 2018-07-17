package patterns.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arkadiusz.Ptak on 17.07.2018.
 */
public abstract class Webside {
    protected List<Page> pages = new ArrayList<>();

    public List<Page> getPages(){
        return pages;
    }

    public Webside(){
        this.createWebside();
    }

    public abstract void createWebside();

}
