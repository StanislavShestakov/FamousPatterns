/**
 * Created by Stas on 29.05.2019.
 */
public class AdapterTutorial {

    /*
    Для обеспечения совместной работы классов, интерфейсы которых несовместимы
    1.интерфейс класса который мы хотим использовать не соотвествует нашим потребностям
    2.необходим класс, который должен взаимодействовать с классами, которые ему не известны или не свзаны с ним
    3.необходимо использовать несколько соотвествующих подклассов,
    но не целесобразно использовать методы этих классов создавая их новые подклассы
     */
    public static void main(String[] args) {
        Database database = new AdapterJavaToDatabase();
        database.insert();
        database.update();
        database.select();
        database.remove();
    }
}
interface Database{
    void insert();
    void update();
    void select();
    void remove();
}
class JavaApplication{
    public void saveObject(){
        System.out.println("Saving Java object...");
    }
    public void updateObject(){
        System.out.println("Updating Java object...");
    }
    public void loadObject(){
        System.out.println("Loading Java object...");
    }
    public void deleteObject(){
        System.out.println("Deleting Java object...");

    }
}
class AdapterJavaToDatabase extends  JavaApplication implements Database{
    @Override
    public void insert() {
        saveObject();
    }

    @Override
    public void update() {
        updateObject();
    }

    @Override
    public void select() {
        loadObject();
    }

    @Override
    public void remove() {
        deleteObject();
    }
}
