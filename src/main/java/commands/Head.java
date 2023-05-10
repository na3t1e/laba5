package commands;

import entity.City;
import managers.CollectionManager;

import java.util.PriorityQueue;

public class Head implements Command {
    @Override
    public void execute(String arg, CollectionManager manager) {
        PriorityQueue<City> entity = manager.getCollection();
        System.out.println("Первый элемент" + entity.peek());
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
