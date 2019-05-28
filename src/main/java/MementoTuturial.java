import java.util.Date;

/**
 * Created by Stas on 28.05.2019.
 */
public class MementoTuturial {
        //фиксирование внутреннего состояния объекта за его пределами не нарушая
        //инкапсуляцию и восстановления объекта в случае необходимости

        //прямое получение свойств нарушает раскрывает реализации и нарушает инкапсуляцию объекта


    public static void main(String[] args) throws InterruptedException {
        Project project = new Project();
        GithubRepo github = new GithubRepo();

        System.out.println("Creating new progect. version 1.0");
        project.setVersionAndDate("version 1.0");

        System.out.println(project);

        System.out.println("Savin current versuion to github///");
        github.setSave(project.save());

        System.out.println("Updating project version 1.1");

        System.out.println("Writing poor code...");
        Thread.sleep(5000);

        System.out.println("version 1.1");

        System.out.println(project);

        System.out.println("Someting went wrong...");

        System.out.println("Rollback version version 1.1");
        project.load(github.getSave());

        System.out.println("Project after rollback");
        System.out.println(project);



    }
}
class Project{
    private String version;
    private Date date;

    public void setVersionAndDate(String version){
        this.version = version;
        this.date = new Date();
    }

    public Save save(){
        return  new Save(version);
    }

    public  void load(Save save){
        this.version = save.getVersion();
        this.date = save.getDate();
    }

    @Override
    public String toString() {
        return "Project:\n" +
                "\nversion='" + version  +
                "\ndate=" + date + "\n";
    }
}

class Save{
    private  final String version;
    private  final Date date;

    Save(String version) {
        this.version = version;
        this.date = new Date();
    }

    public String getVersion() {
        return version;
    }

    public Date getDate() {
        return date;
    }
}
class GithubRepo{
    private Save save;

    public Save getSave() {
        return save;
    }

    public void setSave(Save save) {
        this.save = save;
    }
}
