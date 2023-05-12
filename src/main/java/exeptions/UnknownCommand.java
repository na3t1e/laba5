package exeptions;

public class UnknownCommand extends RuntimeException {
    public UnknownCommand() {
        super("Введите корректную команду");
    }

    public UnknownCommand(String message) {
        super(message);
    }
}
