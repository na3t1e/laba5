package commands;

import entity.City;
import exeptions.IncorrectNumberOfArguments;
import managers.CollectionManager;

import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class CountByMetersAboveSeaLevel implements Command {

    @Override
    public void execute(String arg, CollectionManager manager) {
        if (arg.isBlank()) {
            throw new IncorrectNumberOfArguments();
        }
        AtomicInteger count = new AtomicInteger();
        PriorityQueue<City> collection = manager.getCollection();
        if (collection.isEmpty()) System.out.println("Коллекция пустая, невозможно посчитать количество");
        else {
            try {
                collection.forEach(city -> {
                    if (city.getMetersAboveSeaLevel() == Float.parseFloat(arg)) {
                        count.getAndIncrement();
                    }
                });
            } catch (NumberFormatException n) {
                throw new IncorrectNumberOfArguments();
            }
            System.out.println("Количество элементов: " + count);
        }
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
