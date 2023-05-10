package commands;

import managers.CollectionManager;

public class RemoveById implements Command{
    @Override
    public void execute(String arg, CollectionManager manager) {
        manager.deleteEntity(Long.valueOf(arg));
        System.out.println("Элемент удалён");
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
