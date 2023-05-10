package commands;

import managers.CollectionManager;
import managers.CommandManager;

public class Help implements Command{
    @Override
    public void execute(String arg, CollectionManager collectionManager) {
        System.out.println("Все доступные команды\n");
        CommandManager manager = new CommandManager();
        manager.getCommands().forEach((name, command)-> System.out.println(name + " : " + command.descr()));
    }

    @Override
    public String name() {
        return "help";
    }

    @Override
    public String descr() {
        return "вывести справку по доступным командам";
    }
}
