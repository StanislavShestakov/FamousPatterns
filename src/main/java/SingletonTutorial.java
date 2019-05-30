/**
 * Created by Stas on 30.05.2019.
 */
public class SingletonTutorial {
    /*
    Цел. гарантировать, что у класса будет только один едиснтвеный экземаляр и к немц
    бужет создана глобальная точка доступа.

    1.только один экземпляр, доступный всем.
    2. единственный экземпляр должен наследоваться путем порождения подклассов,
    при этом клиенты, имеют возможность работать с классом наследником без модификации
    своего кода.
     */
    public static void main(String[] args) {
        System.out.println(ProgramLogger.getProgramLogger().toString());
        System.out.println(ProgramLogger.getProgramLogger().toString());
        System.out.println(ProgramLogger.getProgramLogger().toString());
        System.out.println(ProgramLogger.getProgramLogger().toString());
        System.out.println(ProgramLogger.getProgramLogger().toString());

        System.out.println("=========================");

        ProgramLogger.getProgramLogger().addLogInfo("Fisrt log...");
        ProgramLogger.getProgramLogger().addLogInfo("Second log...");
        ProgramLogger.getProgramLogger().addLogInfo("Third log...");

        ProgramLogger.getProgramLogger().showLogFile();
    }
}
class ProgramLogger{
    private static  ProgramLogger programLogger;
    private static String  logFile = "This is log file. \n\n";

    public  static synchronized ProgramLogger getProgramLogger(){
        if(programLogger == null){
            programLogger = new ProgramLogger();
        }
        return  programLogger;
    }

    private  ProgramLogger(){}

    public void addLogInfo(String logInfo){
        logFile += logInfo + "\n";
    }

    public void showLogFile(){
        System.out.println(logFile);
    }
}
