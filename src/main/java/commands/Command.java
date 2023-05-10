package commands;

import managers.CollectionManager;

public interface Command {
    void execute(String arg, CollectionManager manager);

    String name();

    String descr();
}
