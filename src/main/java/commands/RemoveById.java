package commands;

import managers.CollectionManager;

public class RemoveById implements Command{
    @Override
    public void execute(String arg, CollectionManager manager) {
        try {
            if (manager.deleteEntity(Long.parseLong(arg.trim())))
                System.out.println("Элемент удалён");
        } catch (NullPointerException n) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String name() {
        return "remove_by_id id";
    }

    @Override
    public String descr() {
        return "удалить элемент из коллекции по его id";
    }
}
