import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stas on 14.06.2019.
 */
public class MediatorTutorial {
    /*
    Цель. инкапсуляция способа взаимодействия множество объектов, и обеспечения слабой связи между ними.
    1.свзяи между обектами сложны и четко определены
    2.нельзя повторно использовать объект, так как он обмениватеься информацией с другими объектами
    3.поведение, распределнное между несколькими классами должно легко настраиваться без
    создания подклассов.
    * */
    public static void main(String[] args) {
        SimpleTextChat chat = new SimpleTextChat();

        User admin = new Admin(chat, "Admin");
        User user1 = new Admin(chat, "User 1");
        User user2 = new Admin(chat, "User 2");

        chat.setAdmin(admin);
        chat.addUserToChat(user1);
        chat.addUserToChat(user2);

        user1.sendMessage("Hello, I`m user 1");
        admin.sendMessage("Roger that. I am admin!!!");
    }
}

interface Chat {
    void sendMessage(String message, User user);
}

interface User {
    void sendMessage(String message);

    void getdMessage(String message);
}

class Admin implements User {
    Chat chat;
    String name;

    public Admin(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    @Override
    public void getdMessage(String message) {
        System.out.println(this.name + " receiving mesage: " + message + ".");
    }
}

class SimpleUser implements User {
    Chat chat;
    String name;

    public SimpleUser(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    @Override
    public void getdMessage(String message) {
        System.out.println(this.name + " receiving mesage: " + message + ".");
    }
}

class SimpleTextChat implements Chat {
    User admin;
    List<User> users = new ArrayList<>();

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public void addUserToChat(User user) {
        this.users.add(user);
    }

    @Override
    public void sendMessage(String message, User user) {
        for (User u : users) {
            if (u != user) {
                u.getdMessage(message);
            }
        }
        admin.getdMessage(message);
    }
}
