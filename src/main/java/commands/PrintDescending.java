package commands;

import entity.City;
import managers.CollectionManager;

import java.util.*;

public class PrintDescending implements Command{
    @Override
    public void execute(String arg, CollectionManager manager) {
        System.out.println("Элементы  порядке убывания");
        List<City> collect = new ArrayList<>(manager.getCollection());
        Collections.reverse(collect);
        collect.forEach(System.out::println);
    }

    @Override
    public String name() {
        return "print_descending";
    }

    @Override
    public String descr() {
        return "вывести элементы коллекции в порядке убывания";
    }
}
