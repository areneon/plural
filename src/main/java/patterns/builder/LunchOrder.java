package patterns.builder;

/**
 * Created by Arkadiusz.Ptak on 05.12.2017.
 */
public class LunchOrder {

    private final String meat;
    private final String drink;
    private final String condiments;
    private final String dressing;
    private final String mandatory;
    private LunchOrder l;

    public static class Builder{

        private  String meat;
        private  String drink = DEFAULT_DRINK;
        private  String condiments;
        private  String dressing;
        private  String mandatory;


        private static final String DEFAULT_DRINK ="vodka";
        public Builder(String mandatory){
            this.mandatory=mandatory;
        }

        public Builder meat(String meat){
            this.meat=meat;
            return this;
        }

        public Builder drink(String drink){
            this.drink=drink;
            return this;
        }

        public Builder condiments(String condiments){
            this.condiments=condiments;
            return this;
        }

        public Builder dressing(String dressing){
            this.dressing=dressing;
            return this;
        }
        public LunchOrder build(){
            return new LunchOrder(this);
        }
    }
    public LunchOrder(Builder builder){
        this.meat=builder.meat;
        this.drink=builder.drink;
        this.condiments=builder.condiments;
        this.dressing=builder.dressing;
        this.mandatory=builder.mandatory;
    }

    public String getMeat() {
        return meat;
    }

    public String getDrink() {
        return drink;
    }

    public String getCondiments() {
        return condiments;
    }

    public String getDressing() {
        return dressing;
    }

    public String getMandatory() {
        return mandatory;
    }

    @Override
    public String toString(){
        return new StringBuilder()
                .append("mieso: ")
                .append(meat)
                .append(" drink: ")
                .append(drink)
                .append(" dodatki: ")
                .append(condiments)
                .append(" dressing: ")
                .append(dressing)
                .append(" obowiazkowy: ")
                .append(mandatory).toString();
    }
}
