/**
 * Created by Stas on 28.05.2019.
 */
public class StateTutorial {

    //позволяет нам управлять поведением объекта в зависимости лот состояния объекта
    //1.поведение изменяется во время выполнения
    //2.когда встреяается большое количество условных операторов,
    //когда выбор ветви щзависит от состояния объекта
    public static void main(String[] args) {
        Activity activity = new Sleeping();
        Developer3 developer3 = new Developer3();

        developer3.setActivity(activity);

        for (int i = 0; i < 10; i++) {
            developer3.justDoIt();
            developer3.changeActivity();
        }
    }
}
interface  Activity{
    void justDoIt();
}
class Coding implements Activity{
    @Override
    public void justDoIt() {
        System.out.println("Writing code...");
    }
}
class Reading implements Activity{
    @Override
    public void justDoIt() {
        System.out.println("Reading book...");
    }
}
class Sleeping implements Activity{
    @Override
    public void justDoIt() {
        System.out.println("Sleeping...");
    }
}class Training implements Activity{
    @Override
    public void justDoIt() {
        System.out.println("Training...");
    }
}
class Developer3 {
    Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void  changeActivity(){
        if(activity instanceof  Sleeping){
            setActivity(new Training());
        }else if(activity instanceof  Training){
            setActivity(new Coding());
        }else if(activity instanceof Coding){
            setActivity(new Reading());
        }else if(activity instanceof Reading){
            setActivity(new Sleeping());
        }
    }

    public  void justDoIt(){
        activity.justDoIt();
    }
}
