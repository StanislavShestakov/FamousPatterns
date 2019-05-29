/**
 * Created by Stas on 29.05.2019.
 */
public class FacadeTutorial {
    public static void main(String[] args) {
        Job job = new Job();
        job.doJob();
        BugTracker bugTracker = new BugTracker();
        bugTracker.startSprint();
        Developer4 developer = new Developer4();
        developer.doJobBeforeDeadLine(bugTracker);

        bugTracker.finishSprint();
        developer.doJobBeforeDeadLine(bugTracker);
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
