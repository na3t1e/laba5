package commands;

import entity.City;
import managers.CollectionManager;

import java.util.PriorityQueue;

public class Head implements Command {
    @Override
    public void execute(String arg, CollectionManager manager) {
        PriorityQueue<City> collection = manager.getCollection();
        if (collection.isEmpty()) System.err.println("Коллекция пустая");
        else {
            System.out.println("Первый элемент" + collection.peek());
        }
    }

    @Override
    public String name() {
        return "head";
    }

    @Override
    public String descr() {
        return "вывести первый элемент коллекции";
    }
}
