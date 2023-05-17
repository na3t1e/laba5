package managers;

import entity.City;
import entity.Climate;
import entity.Coordinates;
import entity.Human;
import exeptions.ExitRequest;
import exeptions.IncorrectArgumentsExit;

import java.io.*;
import java.time.ZonedDateTime;

public class FileManager {
    static String fileName;

    public static void loadCSV(String filePath, CollectionManager collectionManager) throws FileNotFoundException, ExitRequest, IncorrectArgumentsExit {
        fileName = filePath;
        if (!new File(filePath).exists()) {
            throw new ExitRequest();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int i = 1;
            boolean flag = true;
            while ((line = reader.readLine()) != null) {
                if (i > 0) {
                    i--;
                    continue;
                }
                String[] data = line.split(",");
                try {
                    float f = Float.parseFloat(data[2]);
                    Climate c = Climate.valueOf(data[10]);
                    float f2 = Float.parseFloat(data[7]);
                    ZonedDateTime date = ZonedDateTime.parse(data[4]);
                    if (data[1].isBlank() || Double.parseDouble(data[3]) >= 672 || Double.parseDouble(data[5]) < 1 || Long.parseLong(data[6]) < 1 || Integer.parseInt(data[8]) < 1 || Integer.parseInt(data[8]) > 100000
                            || Double.parseDouble(data[9]) < 1 || Double.parseDouble(data[9]) > 1000 || Float.parseFloat(data[11]) < 1) {
                        flag = false;
                    }
                } catch (IllegalArgumentException exception) {
                    throw new IncorrectArgumentsExit();
                }
                if (!flag) throw new IncorrectArgumentsExit();
                collectionManager.addElementToCollection(new City(data[1], new Coordinates(Float.parseFloat(data[2]), Double.parseDouble(data[3])), ZonedDateTime.parse(data[4]), Double.parseDouble(data[5]),
                        Long.parseLong(data[6]), Float.parseFloat(data[7]), Integer.parseInt(data[8]), Integer.parseInt(data[9]), Climate.valueOf(data[10]), new Human(Float.parseFloat(data[11]))));
            }
        } catch (IOException e) {
            throw new FileNotFoundException("Ошибка чтения файла");
        }
    }

    public static void writeCSV(CollectionManager collectionManager) {
        String fname = fileName.replace("", "") + ".csv";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
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
