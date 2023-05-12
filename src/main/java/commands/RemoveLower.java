package commands;

import entity.City;
import managers.CityManager;
import managers.CollectionManager;

import java.util.PriorityQueue;

public class RemoveLower implements Command {
    @Override
    public void execute(String arg, CollectionManager manager) {
        if (manager.getCollection().isEmpty()) System.out.println("Коллеция пустая, нечего удалять");
        else {
            System.out.println("Введите город");
            City city = new CityManager().collectCity(manager);
            double maxArea = city.getArea();
            PriorityQueue<City> toRemove = new PriorityQueue<>();
            manager.getCollection().forEach(value -> {
                if (value.getArea() < maxArea) {
                    toRemove.add(value);
                }
            });
            manager.deleteEntities(toRemove);
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
