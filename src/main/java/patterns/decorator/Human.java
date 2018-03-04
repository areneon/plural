package patterns.decorator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Human implements IHuman{

    int wiek;
    int wzrost;

    @Override
    public int getWzrost() {
        log.info("Wzrost = {}", wzrost);
        return this.wzrost;
    }

    @Override
    public void breath() {

        log.info("oddycham");
    }

    @Override
    public void walk() {
        log.info("chodze");
    }

    @Override
    public String speak(String word) {
        log.info("Mowie {}", word);
        return word;
    }
}
