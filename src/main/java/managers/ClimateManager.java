package managers;

import entity.Climate;

import java.util.Scanner;

public class ClimateManager {

    Scanner sc = new Scanner(System.in);
    public Climate addClimate(){
        System.out.println("Доступные варианты климата:");
        System.out.println(Climate.names());
        while (true) {
            System.out.println("Введите климат");
            String input = sc.nextLine().trim();
            try{
                return Climate.valueOf(input);
            } catch (IllegalArgumentException exception){
                System.out.println("Такого варианта климата нет в списке");
            } catch (Throwable throwable) {
                System.out.println("Непредвиденная ошибка!");
            }
        }
    }
}
