package commands;

import managers.CollectionManager;
import managers.CommandManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExecuteScript implements Command {

    @Override
    public void execute(String arg, CollectionManager manager) {
//        ArrayDeque<String> filenames = new ArrayDeque<>();
        System.out.println("Выполняется скрипт");
            String filename = arg;

//            filenames.add(filename);
            List<String> arrayListLines = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
                String line;
                while ((line=reader.readLine())!=null){
                    if (!line.trim().isEmpty()) {
                        arrayListLines.add(line);
                    }
                }
            } catch (Exception e) {
//                filenames.clear();
                throw new RuntimeException(e);
            }
            try {
                for (int i = 0; i<arrayListLines.size(); i++){
                    CommandManager commandManager = new CommandManager();
                    System.out.println(Arrays.toString((arrayListLines.get(i) + " ").split(" ", 2)));
                    String[] cmd = (arrayListLines.get(i) + " ").split(" ", 2);

                    commandManager.getCommands().get(cmd[0]).execute(cmd[1], manager );
                }
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
//            filenames.pop();

    }

    @Override
    public String name() {
        return "execute_script file_name";
    }

    @Override
    public String descr() {
        return "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит";
    }
}
