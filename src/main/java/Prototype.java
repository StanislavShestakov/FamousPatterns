/**
 * Created by Stas on 29.05.2019.
 */
public class Prototype {
    /*
    Цел. определить вид создаваемых объектов с помощью экземпляра - прототипа
    и создавать новые объекты, копируя этот прототип

    Используется для создания копий этого объекта

    1.классы, экземпляры которых необходимо создать пределяются в runtime
    2.для избежания построения иерархии классов, фабрик или параллельных иерархий классов.
    3.экземпляры класса могут находится в одном из немногих возможным состояний.

     */
    public static void main(String[] args) {
        Progect master = new Progect(1, "SuperProgject", "SourceCode sc = new SourceCode");
        System.out.println(master);

        Progect masterClone = (Progect) master.copy(); //bad idea but working
        System.out.println("===============================");
        System.out.println(masterClone);

        ProjectFactory factory = new ProjectFactory(master);
        Progect masterClone1 = factory.cloneProject();
        System.out.println("===============================");
        System.out.println(masterClone);

    }
}
interface Copyble{
    Object copy();
}
class Progect implements Copyble{
    private int id;
    private  String projectName;
    private  String sourceCode;

    public Progect(int id, String projectName, String sourceCode) {
        this.id = id;
        this.projectName = projectName;
        this.sourceCode = sourceCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    @Override
    public Object copy() {
        Progect copy = new Progect(id,projectName,sourceCode);
        return copy;
    }

    @Override
    public String toString() {
        return "Progect{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", sourceCode='" + sourceCode + '\'' +
                '}';
    }
}
class ProjectFactory{
    Progect progect;

    public void setProgect(Progect progect) {
        this.progect = progect;
    }

    public ProjectFactory(Progect progect) {

        this.progect = progect;
    }

    Progect cloneProject(){
        return (Progect) progect.copy();
    }
}
