package commands;

import managers.CollectionManager;

public class Exit implements Command{
    @Override
    public void execute(String arg, CollectionManager manager) {
        System.out.println("Программа завершена");
        System.exit(0);
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
