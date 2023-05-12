package commands;

import entity.City;
import managers.CollectionManager;

import java.util.PriorityQueue;

public class Show implements Command {
    @Override
    public void execute(String arg, CollectionManager manager) {

        PriorityQueue<City> collection = manager.getCollection();
        if (collection.isEmpty()) System.out.println("В коллекции нет элементов");
        else {
            System.out.println("Элементы");
            collection.forEach(System.out::println);
        }
    }

    @Override
    public String name() {
        return "show";
    }

    @Override
    public String descr() {
        return "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
