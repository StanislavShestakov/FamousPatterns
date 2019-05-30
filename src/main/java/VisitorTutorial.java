/**
 * Created by Stas on 30.05.2019.
 */
public class VisitorTutorial {
    /*
    Цель. описание действий, которые выполняются с каждым объектом в некоторой структуре
    исп. позволяет определить новую операцию без изменения классов

     1. в структуре присутствуют объекты многих классов с разными интерфейсами
     и нам необходимо выполнить над ними операции без изменения классов в этих объектах.
     2.необходимо выполнять не связанные между собой операции над объектами,
     которые входят в состав структуры и мы не хотим добавлять эти операции в классы.
     3.классы, которые устанавливают струтктуру объектов редко изменяются,
     но часто добаляются операции над этой структурой.
     */
    public static void main(String[] args) {
        Projectt projectt = new Projectt();

        Developer6 junior = new JuniorDeveloper();
        Developer6 senior = new JuniorDeveloper();

        System.out.println("Jun in action....");
        projectt.beWritten(junior);

        System.out.println("===============================");

        System.out.println("Jsenion in action....");
        projectt.beWritten(junior);

    }
}
interface  ProgectElement{
    void beWritten(Developer6 developer6);
}
interface Developer6{
    void create(ProjectClass projectClass);
    void create(Database1 database);
    void create(Test test);
}
class ProjectClass implements ProgectElement{
    @Override
    public void beWritten(Developer6 developer) {
        developer.create(this);
    }
}
class Database1 implements ProgectElement{
    @Override
    public void beWritten(Developer6 developer) {
        developer.create(this);
    }
}
class Test implements ProgectElement{
    @Override
    public void beWritten(Developer6 developer) {
        developer.create(this);
    }
}
class Projectt implements ProgectElement{
    ProgectElement[] progectElements;


    public Projectt() {
        this.progectElements = new  ProgectElement[]{
                new ProjectClass(),
                new Database1(),
                new Test()
        };
    }

    @Override
    public void beWritten(Developer6 developer) {
        for (ProgectElement element:progectElements) {
            element.beWritten(developer);
        }
    }
}
class JuniorDeveloper implements Developer6{
    @Override
    public void create(ProjectClass projectClass) {
        System.out.println("Write poor class...");
    }

    @Override
    public void create(Database1 database) {
        System.out.println("Drop database...");
    }

    @Override
    public void create(Test test) {
        System.out.println("Create unriliable tests...");
    }
}

class SeniorDeveloper implements Developer6{
    @Override
    public void create(ProjectClass projectClass) {
        System.out.println("Rewriting after junior...");
    }

    @Override
    public void create(Database1 database) {
        System.out.println("Fixing database...");
    }

    @Override
    public void create(Test test) {
        System.out.println("Creating riliable tests...");
    }
}