/**
 * Created by Stas on 06.06.2019.
 */
public class ProxyTutorial {
    /*
    Цель, для замещения другого объекта и контроля доступа к нему.
    1.удаленное замещение, - локальный представитель вместо объекта в другом адресном пространстве.
    2.витруальное замещение, - создание "тяжелых объектов" при необходимости
    3.защищенное замещение, - контроль доступа к указанному объекту
    4. "умная ссылка", - замена обычного указателя, (подсчет ссылок, установка блокировки и т.д. и т.п.)
    * */
    public static void main(String[] args) throws InterruptedException {
        Project2 project = new RealProgect("https://www.github.com/StasShestakov/progect");
        project.run();
        Project2 project1 = new ProxyProject("https://www.github.com/StasShestakov/progect");
        Thread.sleep(3000);
        project1.run();
    }
}
interface Project2 {
    void run();
}
class RealProgect implements Project2{
    private  String url;

    public RealProgect(String url) {
        this.url = url;
        load();

    }
    public void load(){
        System.out.println("Loading from url " + url + "..." );
    }

    @Override
    public void run() {
        System.out.println("Running project " + url + "...");
    }
}
class ProxyProject implements Project2{
    private  String url;
    private  RealProgect realProgect;

    public ProxyProject(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        if(realProgect == null){
            realProgect = new RealProgect(url);
        }
        realProgect.run();
    }
}
