/**
 * Created by Stas on 31.05.2019.
 */
public class CommandTutorial {
    /*
    Цель. инкапсулирование запроса в объект
     чтобы задать параметры клиентов для обработки определенных запросов, создание очереди из
       этих запросов или их контроля и поддержки отмены операций

       1.параметризация объектов выполняемых действием
       2.определять запрос, ставить его в очередь и выполнять его в разное время
     */
    public static void main(String[] args) {
         Database2 database = new Database2();
        Developer9 developer = new Developer9(
            new InsertCommand(database),
            new UpdateCommand(database),
            new DeleteCommand(database),
            new SelectCommand(database)
        );
            developer.insertRecord();
            developer.updateRecord();
            developer.selectRecord();
            developer.deleteRecord();
    }
}

class Database2 {
    public void insert() {
        System.out.println("Inserting record");
    }

    public void update() {
        System.out.println("updating record");
    }

    public void select() {
        System.out.println("selecting record");
    }

    public void delete() {
        System.out.println("deleting record");
    }
}

interface Command {
    void execute();
}

class InsertCommand implements Command {
    Database2 database;

    public InsertCommand(Database2 database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.insert();
    }
}

class UpdateCommand implements Command {
    Database2 database;

    public UpdateCommand(Database2 database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.update();
    }
}

class DeleteCommand implements Command {
    Database2 database;

    public DeleteCommand(Database2 database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.delete();
    }
}

class SelectCommand implements Command {
    Database2 database;

    public SelectCommand(Database2 database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.select();
    }
}

class Developer9 {
    Command insert;
    Command delete;
    Command update;
    Command select;

    public Developer9(Command insert, Command delete, Command update, Command select) {
        this.insert = insert;
        this.delete = delete;
        this.update = update;
        this.select = select;
    }

    public void insertRecord() {
        insert.execute();
    }

    public void deleteRecord() {
        delete.execute();
    }

    public void updateRecord() {
        update.execute();
    }

    public void selectRecord() {
        select.execute();
    }
}



