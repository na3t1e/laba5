package commands;

import entity.City;
import managers.CollectionManager;

import java.util.PriorityQueue;

public class Info implements Command {
    @Override
    public void execute(String arg, CollectionManager manager) {
        System.out.println("Информация о коллекции");
        PriorityQueue<City> cities = manager.getCollection();
        System.out.println("тип: " + cities.getClass().toString());
        System.out.println("дата инициализации: " + manager.getInitTime().toString());
        System.out.println("количество элементов: " + cities.size());
    }

    @Override
    public String name() {
        return "info";
    }

    @Override
    public String descr() {
        return "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}
