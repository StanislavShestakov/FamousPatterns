/**
 * Created by Stas on 28.05.2019.
 */
public class DecoratorTutorial {

    //используется  в качестве альтернативы порождению подклассов для
    // расширения функциональности.
    // 1.динамическое и понятное клиентам добавления объектам обязанностей
    // 2.реализация обязанностей, которые могут быть сняты
    // 3.расширения класса путем подключения подклассов невозможно по каким либо причинам.

    public static void main(String[] args) {
        Developer1 developer = new JavaDeveloper2();

        System.out.println(developer.makeJob());

        Developer1 seniorDeveloper = new SeniorJavaDeveloper(new JavaDeveloper2());

        System.out.println(seniorDeveloper.makeJob());

        Developer1 teamLead = new JavaTeamLead(new SeniorJavaDeveloper(new JavaDeveloper2()));

        System.out.println(teamLead.makeJob());
    }
}

interface Developer1 {
    String makeJob();
}

class JavaDeveloper2 implements Developer1 {
    @Override
    public String makeJob() {
        return "Write Java code.";
    }
}

class DeveloperDecorator implements Developer1 {
    Developer1 developer1;

    public DeveloperDecorator(Developer1 developer1) {
        this.developer1 = developer1;
    }

    @Override
    public String makeJob() {
        return developer1.makeJob();
    }
}
class SeniorJavaDeveloper extends  DeveloperDecorator{

    public SeniorJavaDeveloper(Developer1 developer1) {
        super(developer1);
    }

    public String makeCodeReview(){
        return  " Make code review.";
    }

    @Override
    public String makeJob() {
        return super.makeJob() + makeCodeReview();
    }
}
class JavaTeamLead extends  DeveloperDecorator{

    public JavaTeamLead(Developer1 developer1) {
        super(developer1);
    }

    public String sendWeekReport(){
        return  " Send week report to customer.";
    }

    @Override
    public String makeJob() {
        return super.makeJob() + sendWeekReport();
    }
}
