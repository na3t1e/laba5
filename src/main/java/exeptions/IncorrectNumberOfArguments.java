package exeptions;
public class IncorrectNumberOfArguments extends RuntimeException{
    public IncorrectNumberOfArguments() {
        super("Введите правильно аргументы команды");
    }

    public IncorrectNumberOfArguments(String message) {
        super(message);
    }
}
