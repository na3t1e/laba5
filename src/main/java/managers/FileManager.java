package managers;

import entity.City;
import entity.Climate;
import entity.Coordinates;
import entity.Human;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.ZonedDateTime;

public class FileManager {
    public static void loadCSV(String filePath, CollectionManager collectionManager) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int i = 1;
            while ((line = reader.readLine()) != null) {
                if (i > 0) {
                    i--;
                    continue;
                }
                String[] data = line.split(",");
                collectionManager.addElementToCollection(new City(data[1], new Coordinates(Float.valueOf(data[2]), Double.valueOf(data[3])), ZonedDateTime.parse(data[4]), Double.parseDouble(data[5]),
                        Long.valueOf(data[6]), Float.valueOf(data[7]), Integer.parseInt(data[8]), Integer.valueOf(data[9]), Climate.valueOf(data[10]), new Human(Float.valueOf(data[11]))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeCSV(String filePath, CollectionManager collectionManager) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            String[] headers = {"name", "x", "y", "creationDate", "area", "population", "metersAboveSeaLevel", "telephoneCode", "carCode", "climate", "height"};
            fileOutputStream.write("id".getBytes());
            for (String header : headers) {
                fileOutputStream.write(",".getBytes());
                fileOutputStream.write(header.getBytes());
            }
            fileOutputStream.write("\n".getBytes());
            collectionManager.getCollection().forEach(city -> {
                String toFile = city.getId() + "," + city.getName() + "," + city.getCoordinates().getX() + "," + city.getCoordinates().getY() + "," + city.getCreationDate() +
                        "," + city.getArea() + "," + city.getPopulation() + "," + city.getMetersAboveSeaLevel() + "," + city.getTelephoneCode() + "," + city.getCarCode() +
                        "," + city.getClimate() + "," + city.getGovernor().getHeight() + "\n";
                try {
                    fileOutputStream.write(toFile.getBytes());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
