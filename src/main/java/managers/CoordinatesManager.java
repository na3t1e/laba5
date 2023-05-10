package managers;

import entity.Coordinates;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class CoordinatesManager {
    Scanner sc = new Scanner(System.in);

    private @NotNull Float addX() {
        while (true) {
            System.out.println("Введите x:");
            String input = sc.nextLine().trim();
            try {
                return Float.parseFloat(input);
            } catch (NumberFormatException exception) {
                System.out.println("X должнен быть типа float");
            } catch (Throwable throwable) {
                System.out.println("Непредвиденная ошибка!");
            }
        }

    }

    private @NotNull Double addY() {
        while (true) {
            System.out.println("Введите y:");
            String input = sc.nextLine().trim();
            try {
                if (Double.parseDouble(input) >= 672) {
                    System.out.println("Максимальное значение координаты y: 672");
                } else {
                    return Double.parseDouble(input);
                }
            } catch (NumberFormatException exception) {
                System.out.println("Y должнен быть типа double");
            } catch (Throwable throwable) {
                System.out.println("Непредвиденная ошибка!");
            }
        }

    }

    public Coordinates collectCoordinates() {
        return new Coordinates(addX(), addY());
    }
}
