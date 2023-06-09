package commands;

import managers.CollectionManager;

public class Clear implements Command {
    @Override
    public void execute(String arg, CollectionManager manager) {
        if (manager.getCollection().isEmpty()) {
            System.out.println("Коллекция уже пустая");
        } else {
            manager.clearCollection();
            System.out.println("Коллекция очищена");
        }
    }

    @Override
    public String name() {
        return "clear";
    }

    @Override
    public String descr() {
        return "очистить коллекцию";
    }
}
