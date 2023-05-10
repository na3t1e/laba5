package managers;

import commands.*;

import java.util.*;

public class CommandManager {
    private final Map<String, Command> commands = new HashMap<>();

    public CommandManager() {
        getCommands().put("add", new Add());
        commands.put("clear", new Clear());
        commands.put("count_by_meters_above_sea_level", new CountByMetersAboveSeaLevel());
        commands.put("execute_script", new ExecuteScript());
        commands.put("exit", new Exit());
        commands.put("head", new Head());
        commands.put("help", new Help());
        commands.put("info", new Info());
        commands.put("min_by_telephone_code", new MinByTelephoneCode());
        commands.put("print_descending", new PrintDescending());
        commands.put("remove_by_id", new RemoveById());
        commands.put("remove_first", new RemoveFirst());
        commands.put("remove_lower", new RemoveLower());
        commands.put("save", new Save());
        commands.put("show", new Show());
        commands.put("update", new Update());
    }

    public Map<String, Command> getCommands() {
        return commands;
    }

    public void executing(CollectionManager manager) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            Command command = commands.get(tokens[0]);
            command.execute(Arrays.toString(Arrays.copyOfRange(tokens, 1, tokens.length)), manager);
        }
    }


}
