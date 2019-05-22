/**
 * Created by Stas on 22.05.2019.
 */
public class StrategyTest {

    //1. отделите  изменяющиеся части приложения от неизменяющихся, и объедените их в отдельный
    // аспект


    // 2. нужно программировать на уровне интерфейсов, а не на уровне реализаций

    public static void main(String[] args) {
        DoorA door = new DoorA();

        Strategy open = new OpenA();
        door.setStrategy(open);
        door.move();

        Strategy close = new CloseA();
        door.setStrategy(close);
        door.move();

    }
}
class DoorA{
    private  Strategy strategy;
    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }
    public  void  move(){
        strategy.openClose();
    }
}
interface Strategy{
    void openClose();
}
class OpenA implements  Strategy{
    public void openClose() {
        System.out.println("Door is closed!");
    }
}
class CloseA implements Strategy{
    public void openClose() {
        System.out.println("Door is open!");
    }
}
