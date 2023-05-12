import exeptions.ExitRequest;
import managers.CollectionManager;
import managers.CommandManager;
import managers.FileManager;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Не передано название файла для загрузки данных");
            System.exit(1);
        }
        System.out.println("Введите команду команду ниже");
        System.out.println("Для вывода всех комманд напишите 'help'\n");
        while (true) {
            try {
                CollectionManager collectionManager = new CollectionManager();
                FileManager.loadCSV(args[0], collectionManager);
                CommandManager commandManager = new CommandManager();
                commandManager.executing(collectionManager);
            } catch (ExitRequest er) {
                System.out.println("До свидания");
                System.exit(0);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}