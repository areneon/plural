package patterns.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class HumanDecorator implements IHuman{
    private IHuman human;

   public HumanDecorator(IHuman human){
        this.human=human;
    }

    public int getWzrost(){
       log.info("Wzrost: {}",human.getWzrost());
       return human.getWzrost()+powieksz(human.getWzrost());
    }
    abstract protected int powieksz(int wzrost);
}
