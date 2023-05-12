package commands;

import exeptions.IncorrectNumberOfArguments;
import managers.CityManager;
import managers.CollectionManager;

public class Update implements Command{
    @Override
    public void execute(String arg, CollectionManager manager) {
        if (arg.isBlank()){
            throw new IncorrectNumberOfArguments();
        }
        try {
            Long id = Long.parseLong(arg.trim());
            if (manager.checkExist(id)) {
                manager.updateById(Long.parseLong(arg.trim()), new CityManager().collectCity(manager));
                System.out.println("Элемент обновлен");
            }else System.err.println("Элемент не найден");
        }
        catch (NumberFormatException exception) {
            throw new IncorrectNumberOfArguments();
        }

    }

    @Override
    public String name() {
        return "update id {element} ";
    }

    @Override
    public String descr() {
        return "обновить значение элемента коллекции, id которого равен заданному";
    }
}
