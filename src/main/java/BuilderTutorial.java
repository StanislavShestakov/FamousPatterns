/**
 * Created by Stas on 06.06.2019.
 */
public class BuilderTutorial {
    /*
    Цель. отделение сложного объекта от его представления таким образом, что в результате
    одного и того же конструирования мы могли получить разные представления, для создания
    различных объектов из одного набора данных
    1. порядок создания сложного объекта не должен зависеть от того, из каких частей
    состоит объект и того, как эти объекты взаимосвязаны
    2.процесс конструирования объекта должен предоставлять разичные представления объекта,
    который мы конструируем.
    * */
    public static void main(String[] args) {
      //bad Example
        Website website = new Website();

        website.setName("Visit Card");
        website.setCms("Wordpress");
        website.setPrice(1000);


        System.out.println(website);
        System.out.println("==============================");
        //Good Example
        Director director = new Director();
        director.setBuilder(new VisitCarsdWebsiteBuilder());
        WebsiteRight website1 = director.buildWebsite();

        System.out.println(website1);

        System.out.println("==============================");
        director.setBuilder(new EnterpriseWebsiteBuilder());
        WebsiteRight website2 = director.buildWebsite();

        System.out.println(website2);
    }
}
//useless class
class Website {
    private String name;
    private String cms;
    private int price;

    public void setName(String name) {
        this.name = name;
    }

    public void setCms(String cms) {
        this.cms = cms;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Website{" +
                "name='" + name + '\'' +
                ", cms='" + cms + '\'' +
                ", price=" + price +
                '}';
    }
}
class WebsiteRight{
    private String name;
    private Cms cms;
    private int price;

    public void setName(String name) {
        this.name = name;
    }

    public void setCms(Cms cms) {
        this.cms = cms;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "WebsiteRight{" +
                "name='" + name + '\'' +
                ", cms=" + cms +
                ", price=" + price +
                '}';
    }
}
enum Cms{
    WORDPESS,JOOMLA
}
abstract  class  WebsiteBuilder{
    WebsiteRight website;

    void createWebsite(){
        website = new WebsiteRight();
    }
    abstract void buidName();
    abstract void buidCms();
    abstract void buidPrice();

    WebsiteRight getWebsite(){
        return website;
    }
}
class VisitCarsdWebsiteBuilder extends  WebsiteBuilder{
    @Override
    void buidName() {
        website.setName("Visit Card");
    }

    @Override
    void buidCms() {
        website.setCms(Cms.WORDPESS);
    }

    @Override
    void buidPrice() {
        website.setPrice(500);
    }
}
class EnterpriseWebsiteBuilder extends WebsiteBuilder{
    @Override
    void buidName() {
        website.setName("Enterprise web site");
    }

    @Override
    void buidCms() {
        website.setCms(Cms.JOOMLA);
    }

    @Override
    void buidPrice() {
        website.setPrice(10000);
    }
}
class Director{
    WebsiteBuilder builder;

    public void setBuilder(WebsiteBuilder builder) {
        this.builder = builder;
    }

    WebsiteRight buildWebsite(){
        builder.createWebsite();
        builder.buidName();
        builder.buidCms();
        builder.buidPrice();

        WebsiteRight website = builder.getWebsite();
        return website;

    }
}
