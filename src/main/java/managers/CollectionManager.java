package managers;

import entity.City;

import java.time.LocalDateTime;
import java.util.PriorityQueue;

public class CollectionManager {
    private PriorityQueue<City> collection = new PriorityQueue<>();
    private final LocalDateTime initTime;

    public CollectionManager(PriorityQueue<City> collection) {
        this.initTime = LocalDateTime.now();
        this.collection = collection;
    }

    public CollectionManager() {
        this.initTime = LocalDateTime.now();
    }

    public PriorityQueue<City> getCollection() {
        return collection;
    }


    public void addElementToCollection(City value) {
        collection.add(value);
    }


    public LocalDateTime getInitTime() {
        return initTime;
    }

    public void updateById(Long id, City city) {
        deleteEntity(id);
        city.setId(id);
        collection.add(city);
        City.decId();
    }

    public void deleteEntity(Long id) {
        collection.removeIf(entity -> entity.getId().equals(id));
    }

    public void clearCollection() {
        this.collection.clear();
    }
}
