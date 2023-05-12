package commands;

import exeptions.UnknownCommand;
import managers.CollectionManager;
import managers.CommandManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ExecuteScript implements Command {
    private static List<String> names = new ArrayList<>();

    @Override
    public void execute(String arg, CollectionManager manager) {
        names.add(arg.trim());
//        System.out.println("Выполняется скрипт");
        if (!new File(arg).exists()) {
            throw new IllegalArgumentException("Введенный файл не существует");
        }
        if (!new File(arg).isFile()) {
            throw new IllegalArgumentException("Вы ввели название дериктории, а не файла");
        }
        List<String> listOfLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(arg))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    listOfLines.add(line);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < listOfLines.size(); i++) {
            try {
                CommandManager commandManager = new CommandManager();
                String[] commands = (listOfLines.get(i) + " ").split(" ", 2);
                System.out.println(names.toString());
                System.out.println(listOfLines);
                if (names.contains(commands[1])) {
                    System.out.println("Повторение");
                    throw new IllegalArgumentException("Рекурсивный вызов файлов");
                } else {
                    Command command = commandManager.getCommands().get(commands[0]);
                    System.out.println(command);
                    command.execute(commands[1] == null ? "" : commands[1], manager);
                }
            } catch (RuntimeException re) {
                throw new UnknownCommand();
            } catch(Exception e){
            throw new RuntimeException();
        }
    }

}

    @Override
    public String name() {
        return "execute_script file_name";
    }

    @Override
    public String descr() {
        return "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит";
    }
}
