package commands;

import exeptions.ExitRequest;
import managers.CollectionManager;

public interface Command {
    void execute(String arg, CollectionManager manager) throws ExitRequest;

    String name();

    String descr();
}
