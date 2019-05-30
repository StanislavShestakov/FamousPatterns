/**
 * Created by Stas on 30.05.2019.
 */
public class BridgeTutorial {
    /*
    Цель. отделить абстракцию от её реализации, чтоьбы независимо менять одно и другое
     для получения преимуществ наследования без потери гибкости

     1.предотвращение жесткой привязки абстракции к реализации (например раилизацию необходимо выбпрать в runtime)
     2.в будущем мы хотим расширять с помощью подклассов и реалтзацию и абстракцию
     3. если изменения реалитзации не должны отражаться на клиентах абстракции
     4. для разделения ождной реализации между несколькими объектами и не показывать это клиенту.

     */
    public static void main(String[] args) {
        Program [] programs = {
                new BankSystem(new JavaDeveloper3()),
                new StokExchange(new CppDeveloper1()),
                new BankSystem(new CppDeveloper1()),
                new StokExchange(new JavaDeveloper3())
        };
        for(Program program: programs){
            program.developProgram();
        }
    }
}
abstract class Program{
    protected Developer5 developer;

    protected  Program(Developer5 developer){
        this.developer = developer;
    }

    public abstract void developProgram();
}
interface Developer5{
    void writeCode();
}
class JavaDeveloper3 implements Developer5 {

    @Override
    public void writeCode() {
        System.out.println("Java developer write java code");
    }
}

class CppDeveloper1 implements Developer5 {
    @Override
    public void writeCode() {
        System.out.println("C++ developer write C++ code");
    }
}
class BankSystem extends Program{

    public BankSystem(Developer5 developer) {
        super(developer);
    }

    @Override
    public void developProgram() {
        System.out.println("Bank Sysytem development in progress.");
        developer.writeCode();
    }
}
class StokExchange extends Program{


    public StokExchange(Developer5 developer) {
        super(developer);
    }

    @Override
    public void developProgram() {
        System.out.println("Stok Excange development in progress.");
        developer.writeCode();
    }
}

