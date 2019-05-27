/**
 * Created by Stas on 27.05.2019.
 */
public class IteratorTutorial {

    //используется для получения доступа ко всем элементам составного объекта,
    //скрывая его внутренне представление

    public static void main(String[] args) {
        String[] skills = {"Java", "String", "Hibernate", "Maven","PostgreSQL"};

        JavaDeveloper1 javaDeveloper1 = new JavaDeveloper1("Stas Shestakov", skills);
        Iterator iterator = javaDeveloper1.getIterator();
        System.out.println("Developer: " + javaDeveloper1.getName());
        System.out.println("Skills: ");

        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
   }

}

interface Iterator {
    public boolean hasNext();

    public Object next();

}

interface Collection {
    Iterator getIterator();
}

class JavaDeveloper1 implements Collection {
    private String name;
    private String[] skills;

    public JavaDeveloper1(String name, String[] skills) {
        this.name = name;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    @Override
    public Iterator getIterator() {
        return new SkillIterator();
    }

    private class SkillIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if (index < skills.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            return skills[index++];
        }
    }
}

