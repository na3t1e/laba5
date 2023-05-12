package managers;

import entity.City;

import java.time.LocalDateTime;
import java.util.Collection;
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
    public boolean checkExist(Long id) {
        return collection.stream()
                .anyMatch((x) -> x.getId().equals(id));
    }


    public void addElementToCollection(City value) {
        collection.add(value);
    }


    public LocalDateTime getInitTime() {
        return initTime;
    }

    public void updateById(Long id, City city) {
        if (deleteEntity(id)) {
            city.setId(id);
            collection.add(city);
            City.decId();
        }
    }

    public void deleteEntities(Collection<City> toRemove) {
        if (collection.removeAll(toRemove)){
            System.out.println("Элемент(ы) удалены");
        }
    }
    public boolean deleteEntity(Long id) {
        if (
        !collection.removeIf(entity -> entity.getId().equals(id))){
            System.out.println("Элемент не существует");
            return false;
        }
        return true;
    }

    public void clearCollection() {
        this.collection.clear();
    }
}
