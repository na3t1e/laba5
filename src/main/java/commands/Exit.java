package commands;

import exeptions.ExitRequest;
import managers.CollectionManager;

public class Exit implements Command {
    @Override
    public void execute(String arg, CollectionManager manager) throws ExitRequest {
        System.out.println("Программа завершена");
        throw new ExitRequest();
    }

    @Override
    public String name() {
        return "exit";
    }

    @Override
    public String descr() {
        return "завершить программу (без сохранения в файл)";
    }
}
