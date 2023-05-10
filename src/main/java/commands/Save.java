package commands;

import managers.CollectionManager;
import managers.FileManager;

public class Save implements Command{
    @Override
    public void execute(String arg, CollectionManager manager) {
        FileManager.writeCSV("data.csv", manager);
        System.out.println("Коллекция сохранена");
    }

    @Override
    public String name() {
        return "save";
    }

    @Override
    public String descr() {
        return "сохранить коллекцию в файл";
    }
}
