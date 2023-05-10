package commands;

import managers.CityManager;
import managers.CollectionManager;

public class Update implements Command{
    @Override
    public void execute(String arg, CollectionManager manager) {
        manager.updateById(Long.parseLong(arg), new CityManager().collectCity());
        System.out.println("Элемент обновлен");
    }

    @Override
    public String name() {
        return "update id {element} ";
    }

    @Override
    public String descr() {
        return "обновить значение элемента коллекции, id которого равен заданному";
    }
}
