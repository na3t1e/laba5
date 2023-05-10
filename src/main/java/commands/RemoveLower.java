package commands;

import entity.City;
import managers.CityManager;
import managers.CollectionManager;

public class RemoveLower implements Command{
    @Override
    public void execute(String arg, CollectionManager manager) {
        System.out.println("Введите город:");
        City city = new CityManager().collectCity();
        double maxArea = city.getArea();
        manager.getCollection().forEach(value -> {
            if (city.getArea()<maxArea){
                manager.deleteEntity(city.getId());
            }
        });
        System.out.println("Элементы удалены");
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
