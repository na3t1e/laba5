package commands;

import entity.City;
import managers.CityManager;
import managers.CollectionManager;

import java.util.Collection;

public class RemoveLower implements Command {
    @Override
    public void execute(String arg, CollectionManager manager) {
        if (manager.getCollection().isEmpty()) System.out.println("Коллеция пустая, нечего удалять");
        else {
            System.out.println("Введите город");
            City city = new CityManager().collectCity(manager);
            double maxArea = city.getArea();
            Collection<City> toRemove = null;
            manager.getCollection().forEach(value -> {
                if (value.getArea() < maxArea) {
                    toRemove.add(value);
                }
            });
            manager.deleteEntities(toRemove);
//            System.out.println("Элементы удалены");
        }
    }

    @Override
    public String name() {
        return "remove_lower {element}";
    }

    @Override
    public String descr() {
        return "удалить из коллекции все элементы, меньшие, чем заданный";
    }
}
