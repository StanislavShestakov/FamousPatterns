/**
 * Created by Stas on 29.05.2019.
 */
public class FacadeTutorial {
    /*
    Цель: предоставить унифицированный интерфейс вместо нескольких
    интерфейсов подсистем
    используеться для определения интерфейса высокого уровня, который упрощает использование подсистемы

    1.использование клиентов от компонентов подсистемы, упрощая работу с ней;
    2.необходимость ослабления свызаности подсистемы с клиентами.
     */
    public static void main(String[] args) {
        Workflow workflow = new Workflow();

        workflow.solveProblems();
    }
}
class Job{
    public  void doJob(){
        System.out.println("Job in progress....");
    }
}
class BugTracker{
    private  boolean activeSprint;

    public boolean isActiveSprint() {
        return  activeSprint;
    }

    public  void startSprint(){
        System.out.println("Sprint is active.");
        activeSprint = true;
    }

    public  void finishSprint(){
        System.out.println("Sprint is inactive.");
        activeSprint = false;
    }
}
class Developer4{
    public void doJobBeforeDeadLine(BugTracker bugTracker){
        if (bugTracker.isActiveSprint()){
            System.out.println("Developer write code");
        }else{
            System.out.println("Developer is reading stackoverflow");
        }
    }
}
class Workflow{
    Developer4 developer = new Developer4();
    Job job = new Job();
    BugTracker bugTracker = new BugTracker();

    public  void solveProblems(){
        job.doJob();
        bugTracker.finishSprint();
        developer.doJobBeforeDeadLine(bugTracker);
    }
}
