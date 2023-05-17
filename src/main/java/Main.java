import exeptions.ExitRequest;
import exeptions.IncorrectArgumentsExit;
import managers.CollectionManager;
import managers.CommandManager;
import managers.FileManager;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Не передано название файла для загрузки данных");
            System.exit(1);
        }
        CollectionManager collectionManager = new CollectionManager();
        try {
            FileManager.loadCSV(args[0], collectionManager);
        } catch (FileNotFoundException f){
            System.err.println(f.getMessage());
            System.exit(1);
        } catch (ExitRequest e) {
            System.err.println("Введенный файл не существует");
            System.exit(1);
        } catch (IncorrectArgumentsExit e) {
            System.err.println("В данных файла ошибка, невозможно импортировать коллекцию");
            System.exit(1);
        }

        System.out.println("Введите команду команду ниже");
        System.out.println("Для вывода всех комманд напишите 'help'\n");
        while (true) {
            try {
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