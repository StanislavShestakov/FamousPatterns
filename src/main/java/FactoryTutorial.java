import static javafx.scene.input.KeyCode.J;

/**
 * Created by Stas on 24.05.2019.
 */
public class FactoryTutorial {
    //1.фабричный метод позволяет определить общий интерфейс создания объектов
    //(продуктов), при этом позволяя субклассам выбирать конкртеный  продукт
    //для создания
    //2. паттерн инкапсулирует создание объектов
    public static void main(String[] args) {
        DeveloperFactory developerFactory = createDeveloperFactoryBySpecialty("c++");
        Developer developer = developerFactory.createDeveloper();
        developer.writecode();
    }

    static DeveloperFactory createDeveloperFactoryBySpecialty(String specialty) {
        if (specialty.equalsIgnoreCase("java")) {
            return new JavaDeveloperFactory();
        } else if (specialty.equalsIgnoreCase("c++")) {
            return new CppDeveloperFactory();
        } else {
            throw new RuntimeException(specialty + " is unknown specialty.");
        }
    }
}

interface Developer {
    void writecode();
}

class JavaDeveloper implements Developer {

    @Override
    public void writecode() {
        System.out.println("Java developer write java code");
    }
}

class CppDeveloper implements Developer {
    @Override
    public void writecode() {
        System.out.println("C++ developer write C++ code");
    }
}

class JavaDeveloperFactory implements DeveloperFactory {
    @Override
    public Developer createDeveloper() {
        return new JavaDeveloper();
    }
}

class CppDeveloperFactory implements DeveloperFactory {
    @Override
    public Developer createDeveloper() {
        return new CppDeveloper();
    }
}

interface DeveloperFactory {
    Developer createDeveloper();
}

