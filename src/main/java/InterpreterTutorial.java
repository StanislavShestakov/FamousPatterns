/**
 * Created by Stas on 31.05.2019.
 */
public class InterpreterTutorial {
    /*
        Цель. определение представления грамматики объекта

        используется для попределеляния представления грамматики заданного языка
        и интерпритации его предложений

        1.упрощение иерархии классов с помощью интерпретирования
      */
    public static void main(String[] args) {
        Expression isJava = getJavaExpression();
        Expression isJavaEEDeveloper = getJavaEEExpression();

        System.out.println("Does developer knows Java Core:" + isJava.interpret("Java Core"));
        System.out.println("Does developer knows Java EE:" + isJavaEEDeveloper.interpret("Java Spring"));
    }
    public static  Expression getJavaExpression(){
       Expression java = new TerminalExpession("Java");
       Expression javaCore = new TerminalExpession("Java Core");

        return  new OrExpession(java, javaCore);
    }
    public static  Expression getJavaEEExpression(){
        Expression java = new TerminalExpession("Java");
        Expression spring = new TerminalExpession("Spring");

        return  new OrExpession(java, spring);
    }

}
interface  Expression{
    boolean interpret(String context);
}
class AndExpession implements Expression{
    private  Expression expression1;
    private  Expression expression2;

    public AndExpession(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String context) {
        return expression1.interpret(context) && expression2.interpret(context);
    }
}
class OrExpession implements Expression{
    private  Expression expression1;
    private  Expression expression2;

    public OrExpession(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String context) {
        return expression1.interpret(context) || expression2.interpret(context);
    }
}
class TerminalExpession implements Expression{
    private  String data;


    public TerminalExpession(String data) {
       this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if(context.contains(data)){
            return  true;
        }
        return false;
    }
}

