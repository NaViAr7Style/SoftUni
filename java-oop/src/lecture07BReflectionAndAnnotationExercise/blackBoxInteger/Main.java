package lecture07BReflectionAndAnnotationExercise.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> ctor = clazz.getDeclaredConstructor();
        ctor.setAccessible(true);
        BlackBoxInt blackBoxInt = ctor.newInstance();

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Field hiddenValue = clazz.getDeclaredField("innerValue");
        hiddenValue.setAccessible(true);

        while (!"END".equals(command)) {
            String[] tokens = command.split("_");
            String methodName = tokens[0];
            int argument = Integer.parseInt(tokens[1]);

            Method method = clazz.getDeclaredMethod(methodName, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, argument);

            System.out.println(hiddenValue.get(blackBoxInt));
            command = scanner.nextLine();
        }

    }
}
