package commands;

import entity.City;
import managers.CollectionManager;

import java.util.PriorityQueue;

public class MinByTelephoneCode implements Command {
    @Override
    public void execute(String arg, CollectionManager manager) {
        City city = new City();
        int number = 2147483647;
        PriorityQueue<City> collection = manager.getCollection();
        for (City entity : collection) {
            if (entity.getTelephoneCode() <= number) {
                city = entity;
                number = entity.getTelephoneCode();
            }
        }
        System.out.println("Элемент с минимальным telephoneCode: " + city);
    }

    @Override
    public String name() {
        return "min_by_telephone_code";
    }

    @Override
    public String descr() {
        return "вывести любой объект из коллекции, значение поля telephoneCode которого является минимальным";
    }
}
