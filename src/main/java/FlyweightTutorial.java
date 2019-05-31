import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Stas on 31.05.2019.
 */
public class FlyweightTutorial {
    /*
    Цель. поддержка множества мелких объетов

    1.когда используется большое число объектов
    2.большую часть состояния объектов можно вынести наружу
    3. приложение не зависи от идентичности объекта
     */
    public static void main(String[] args) {
        DeveloperFactory1 developerFactory = new DeveloperFactory1();
        List<Developer8> developers = new ArrayList<>();

        developers.add(developerFactory.getDeveloperBySpecialty("java"));
        developers.add(developerFactory.getDeveloperBySpecialty("java"));
        developers.add(developerFactory.getDeveloperBySpecialty("java"));
        developers.add(developerFactory.getDeveloperBySpecialty("java"));
        developers.add(developerFactory.getDeveloperBySpecialty("java"));
        developers.add(developerFactory.getDeveloperBySpecialty("java"));
        developers.add(developerFactory.getDeveloperBySpecialty("java"));
        developers.add(developerFactory.getDeveloperBySpecialty("java"));
        developers.add(developerFactory.getDeveloperBySpecialty("java"));
        developers.add(developerFactory.getDeveloperBySpecialty("java"));
        developers.add(developerFactory.getDeveloperBySpecialty("c++"));
        developers.add(developerFactory.getDeveloperBySpecialty("c++"));
        developers.add(developerFactory.getDeveloperBySpecialty("c++"));
        developers.add(developerFactory.getDeveloperBySpecialty("c++"));
        developers.add(developerFactory.getDeveloperBySpecialty("c++"));
        developers.add(developerFactory.getDeveloperBySpecialty("c++"));
        developers.add(developerFactory.getDeveloperBySpecialty("c++"));


        for (Developer8 developer : developers) {
            developer.writeCode();
        }
    }
}

interface Developer8 {
    void writeCode();
}

class JavaDeveloper5 implements Developer8 {

    @Override
    public void writeCode() {
        System.out.println("Java developer write java code");
    }
}

class CppDeveloper4 implements Developer8 {
    @Override
    public void writeCode() {
        System.out.println("C++ developer write C++ code");
    }
}

class DeveloperFactory1 {
    private static final Map<String, Developer8> developers = new HashMap<>();


    public Developer8 getDeveloperBySpecialty(String specialty) {
        Developer8 developer = developers.get(specialty);

        if (developer == null) {
            switch (specialty) {
                case "java":
                    System.out.println("Hiring Java developer...");
                    developer = new JavaDeveloper5();
                    break;
                case "c++":
                    System.out.println("Hiring C++ developer...");
                    developer = new CppDeveloper4();
            }
            developers.put(specialty, developer);
        }
        return developer;
    }
}

