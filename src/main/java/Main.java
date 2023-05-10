import managers.CollectionManager;
import managers.CommandManager;
import managers.FileManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CollectionManager collectionManager = new CollectionManager();
        FileManager.loadCSV(args[0], collectionManager);
        CommandManager commandManager = new CommandManager();
        commandManager.executing(collectionManager);
    }
}