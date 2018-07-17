package patterns.factory;

import static patterns.factory.SiteType.*;

/**
 * Created by Arkadiusz.Ptak on 17.07.2018.
 */
public class WebsideFactory {

    public static Webside getWebside(SiteType siteType){
        switch(siteType){
            case BLOG : {
                return new Blog();
            }

            case SHOP : {
                return new Shop();
            }
            default:{
                return new Blog();
            }
        }
    }

}
