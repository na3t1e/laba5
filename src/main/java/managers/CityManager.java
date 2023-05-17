package managers;

import entity.*;
import org.jetbrains.annotations.NotNull;

import java.time.ZonedDateTime;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class CityManager {
    Scanner sc = new Scanner(System.in);

    public CityManager() {
    }

    private @NotNull String addName() {
        String name;
        while (true) {
            System.out.println("Введите название:");
            name = sc.nextLine().trim();
            if (name.isBlank()) {
                System.err.println("Название не может быть пустым");
            } else return name;
        }
    }

    private Coordinates addCoordinates() {
        return new CoordinatesManager().collectCoordinates();
    }

    private @NotNull Double addArea() {
        while (true) {
            System.out.println("Введите площадь:");
            String input = sc.nextLine().trim();
            try {
                if (Double.parseDouble(input) < 1) {
                    System.err.println("Значение области должно быть больше 0");
                } else {
                    return Double.parseDouble(input);
                }
            } catch (NumberFormatException exception) {
                System.err.println("Область должна быть типа double");
            } catch (Throwable throwable) {
                System.err.println("Непредвиденная ошибка!");
            }
        }
    }

    private @NotNull Long addPopulation() {
        while (true) {
            System.out.println("Введите население:");
            String input = sc.nextLine().trim();
            try {
                if (Long.parseLong(input) < 1) {
                    System.err.println("Значение населения должно быть больше 0");
                } else {
                    return Long.parseLong(input);
                }
            } catch (NumberFormatException exception) {
                System.err.println("Область должна быть типа long");
            } catch (Throwable throwable) {
                System.err.println("Непредвиденная ошибка!");
            }
        }
    }

    private @NotNull Float addMetersAboveSeaLevel() {
        while (true) {
            System.out.println("Введите количество метров над уровнем моря:");
            String input = sc.nextLine().trim();
            try {
                return Float.parseFloat(input);
            } catch (NumberFormatException exception) {
                System.err.println("Область должна быть типа float");
            } catch (Throwable throwable) {
                System.err.println("Непредвиденная ошибка!");
            }
        }
    }

    private int addTelephoneCode(CollectionManager manager) {
        while (true) {
            System.out.println("Введите телефонный код:");
            String input = sc.nextLine().trim();
            try {
                if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 100000) {
                    System.err.println("Значение телефонного кода должно быть в диапазоне [1, 100000]");
                } else {
                    int code = Integer.parseInt(input);
                    AtomicBoolean unique = new AtomicBoolean(true);
                    manager.getCollection().forEach(city -> {
                        if (city.getTelephoneCode() == code){
                            unique.set(false);
                        }
                    }
                    );
                    if (unique.get()) return code;
                    else {
                        System.err.println("Значение телефонного кода должно быть уникальным");
                        return addTelephoneCode(manager);
                    }
                }
            } catch (NumberFormatException exception) {
                System.err.println("Область должна быть типа int");
            } catch (Throwable throwable) {
                System.err.println("Непредвиденная ошибка!");
            }
        }
    }

    private @NotNull Integer addCarCode() {
        while (true) {
            System.out.println("Введите код номера машин:");
            String input = sc.nextLine().trim();
            try {
                if (Double.parseDouble(input) < 1 || Double.parseDouble(input) > 1000) {
                    System.err.println("Значение кода номера машин должно быть в диапазоне [1, 1000]");
                } else {
                    return Integer.parseInt(input);
                }
            } catch (NumberFormatException exception) {
                System.err.println("Область должна быть типа int");
            } catch (Throwable throwable) {
                System.err.println("Непредвиденная ошибка!");
            }
        }
    }

    private Climate addClimate() {
        return new ClimateManager().addClimate();
    }

    private Human addHuman() {
        return new HumanManager().collectHuman();
    }


    public City collectCity(CollectionManager manager) {
        return new City(addName(), addCoordinates(), ZonedDateTime.now(), addArea(), addPopulation(), addMetersAboveSeaLevel(), addTelephoneCode(manager), addCarCode(), addClimate(), addHuman());
    }
}
