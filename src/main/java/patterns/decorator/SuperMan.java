package patterns.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SuperMan extends HumanDecorator {
    public SuperMan(IHuman human){
        super(human);
    }

    @Override
    public int powieksz(int wzrost) {
        return wzrost *2;
    }

    @Override
    public void breath() {
        breathInSpace();
        log.info("Superman oddycha w kosmosie");
    }

    @Override
    public void walk() {
        log.info("Superman lata !!!");
    }

    @Override
    public String speak(String word) {
        log.info("Krzyczę: {} !!! i jestem zajebisty",word);
        return word.concat("!!!");
    }

    private void breathInSpace(){
        log.info("potrafie oddychac w kosmosie");
    }
}
