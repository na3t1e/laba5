package commands;

import entity.City;
import managers.CollectionManager;

import java.util.PriorityQueue;

public class RemoveFirst implements Command{
    @Override
    public void execute(String arg, CollectionManager manager) {
        if (manager.getCollection().isEmpty()) System.out.println("Коллеция пустая, нечего удалять");
        else {
            PriorityQueue<City> entity = manager.getCollection();
            System.out.println(entity.poll());
            System.out.println("Первый элемент удалён");
        }
    }

    @Override
    public String name() {
        return "remove_first";
    }

    @Override
    public String descr() {
        return "удалить первый элемент из коллекции";
    }
}
