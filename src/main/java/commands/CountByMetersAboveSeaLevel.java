package commands;

import entity.City;
import managers.CollectionManager;

import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class CountByMetersAboveSeaLevel implements Command{

    @Override
    public void execute(String arg, CollectionManager manager)
    {
        AtomicInteger count = new AtomicInteger();
        PriorityQueue<City> collection = manager.getCollection();
        collection.forEach(city -> {
            if (city.getMetersAboveSeaLevel() == Float.parseFloat(arg)){
                count.getAndIncrement();
            }
        });
        System.out.println("Количество элементов: " + count);
    }

    @Override
    public String name() {
        return "count_by_meters_above_sea_level metersAboveSeaLevel";
    }

    @Override
    public String descr() {
        return "вывести количество элементов, значение поля metersAboveSeaLevel которых равно заданному";
    }
}
