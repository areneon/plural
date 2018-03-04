package patterns.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AquaMan extends HumanDecorator{

    public AquaMan(IHuman human){
    super(human);
    }

    @Override
    public int powieksz(int wzrost) {
        return wzrost *3;
    }

    @Override
    public void breath() {
        breathUnderWater();
        log.info("AquaMan nie musi oddychac");
    }

    @Override
    public void walk() {
        log.info("AquaMan pływa zamiast chodzi");
    }

    @Override
    public String speak(String word) {
        log.info("Krzyczę: {} !!!",word);
        return word.concat("!!!");
    }
    private void breathUnderWater(){
        log.info("Potrafie oddychac pod wodą");
    }
}
