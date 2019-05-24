import java.util.ArrayList;
import java.util.List;


/**
 * Created by Stas on 24.05.2019.
 */
public class ObserverTutorial {
//    наблюдатель, определяет отношение один-ко-многим между объектами,
//    позволяя при этом оповещать зависимые объекты наблюдателей об
//    изменениях в объекте субъекта
    public static void main(String[] args) {
        JavaDeveloperJobSite jobSite = new JavaDeveloperJobSite();
        jobSite.addVacancy("First Job Position");
        jobSite.addVacancy("Second Job Position");

        Observer firsSbcr = new Subscriber("Stas Shestakov");
        Observer secondSbcr = new Subscriber("Dmitriy Ghorohovcev");

        jobSite.addObserever(firsSbcr);
        jobSite.addObserever(secondSbcr);

        jobSite.addVacancy("Third Java Position");

        jobSite.removeVacancy("First Job Position");
    }
}
interface Observer{
    void handlerEvent(List<String> vacancies);
}
interface Observed{
    void addObserever(Observer obs);
    void removeObserever(Observer obs);
    void notifyObserevers();
}
class Subscriber implements Observer{
    String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void handlerEvent(List<String> vacancies){
        System.out.println("Dear " + name + "\n we have some changes in vacancies:\n"
        + vacancies + "\n=================================================\n");
    }

}
class JavaDeveloperJobSite implements Observed{
    List<String> vacancies = new ArrayList<>();
    List<Observer> subcribers = new ArrayList<>();
   public  void addVacancy(String vacancy){
       this.vacancies.add(vacancy);
       notifyObserevers();
   }
   public void removeVacancy(String vacancy){
       this.vacancies.remove(vacancy);
       notifyObserevers();
   }

    @Override
    public void addObserever(Observer obs) {
        this.subcribers.add(obs);
    }

    @Override
    public void removeObserever(Observer obs) {
        this.subcribers.remove(obs);
    }

    @Override
    public void notifyObserevers() {
        for (Observer obs:subcribers) {
            obs.handlerEvent(this.vacancies);
        }
    }
}
