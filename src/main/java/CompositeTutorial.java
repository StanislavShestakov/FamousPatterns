import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 30.05.2019.
 */
public class CompositeTutorial {
    /*
    Цель. скомпоновать объекты в структуры по типу "дерева", позволяя клиентам единообразно трактовать отдельные
    и составные объекты. Мелкие компонует в крупные.

    1. для предоставления иерархии "часть-целое";
    2. мы хотим, чтобы клиенты одним способом трактоывали как отдельные,
      как отдельные так и составные объеты
     */
    public static void main(String[] args) {
        Team team = new Team();

        Developer7 fstJavaDeveloper = new JavaDeveloper4();
        Developer7 scdJavaDeveloper = new JavaDeveloper4();
        Developer7 cppDeveloper = new CppDeveloper3();

        team.addDeveloper(fstJavaDeveloper);
        team.addDeveloper(scdJavaDeveloper);
        team.addDeveloper(cppDeveloper);

        team.createPrjgect();
    }
}

class Team {
    private List<Developer7> developers = new ArrayList<>();

    public void addDeveloper(Developer7 developer) {
        developers.add(developer);
    }

    public void removeDeveloper(Developer7 developer) {
        developers.remove(developer);
    }

    public void createPrjgect() {
        for (Developer7 developer : developers) {
            developer.writeCode();
        }
    }
}

interface Developer7 {
    void writeCode();
}

class JavaDeveloper4 implements Developer7 {

    @Override
    public void writeCode() {
        System.out.println("Java developer write java code");
    }
}

class CppDeveloper3 implements Developer7 {

    @Override
    public void writeCode() {
        System.out.println("c++ developer write java c++ code");

    }
}
