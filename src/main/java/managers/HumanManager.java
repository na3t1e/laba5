package managers;

import entity.Human;

import java.util.Scanner;

public class HumanManager {
    Scanner sc = new Scanner(System.in);

    public Float addHeight() {
        while (true) {
            System.out.println("Введите рост губернатора:");
            String input = sc.nextLine().trim();
            try {
                if (Long.parseLong(input) < 1) {
                    System.out.println("Значение роста должно быть больше 0");
                } else {
                    return Float.parseFloat(input);
                }
            } catch (NumberFormatException exception) {
                System.out.println("Рост должен быть типа float");
            } catch (Throwable throwable) {
                System.out.println("Непредвиденная ошибка!");
            }
        }
    }

    public Human collectHuman() {
        return new Human(addHeight());
    }
}
