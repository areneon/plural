package patterns.factory;

/**
 * Created by Arkadiusz.Ptak on 17.07.2018.
 */
public enum SiteType {

    BLOG ("blog"),
    SHOP ("shop");

    private final String value;

    SiteType(String siteType) {
        this.value=siteType;
    }

    public String getValue() {
        return value;
    }
}
