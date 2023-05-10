package commands;

import managers.CityManager;
import managers.CollectionManager;

public class Add implements Command {
    @Override
    public void execute(String arg, CollectionManager manager) {
        manager.addElementToCollection(new CityManager().collectCity());
        System.out.println("Элемент добавлен в коллекцию");
    }

    @Override
    public String name() {
        return "add {element}";
    }

    @Override
    public String descr() {
        return "добавить новый элемент в коллекцию";
    }
}
