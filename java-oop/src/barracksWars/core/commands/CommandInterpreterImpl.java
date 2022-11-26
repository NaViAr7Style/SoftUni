package barracksWars.core.commands;

import barracksWars.annotations.Inject;
import barracksWars.interfaces.CommandInterpreter;
import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {

    public final static String COMMAND_PACKAGE_NAME = "barracksWars.core.commands.";
    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        String className = parseCommandToClassName(commandName);
        Executable command = null;

        try {
            Class clazz = Class.forName(className);
            Constructor<Command> constructor = clazz.getDeclaredConstructor(String[].class);
            command = constructor.newInstance(new Object[]{data});
            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {
                if (field.isAnnotationPresent(Inject.class)) {
                    if (field.getType().equals(Repository.class)) {
                        field.setAccessible(true);
                        field.set(command, repository);
                    } else if (field.getType().equals(UnitFactory.class)) {
                        field.setAccessible(true);
                        field.set(command, unitFactory);
                    }
                }
            }

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return command;
    }

    private String parseCommandToClassName(String commandName) {
        return COMMAND_PACKAGE_NAME + commandName.substring(0, 1).toUpperCase() + commandName.substring(1) + "Command";
    }

}