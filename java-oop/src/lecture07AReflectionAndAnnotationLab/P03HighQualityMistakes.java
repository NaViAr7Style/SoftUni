package lecture07AReflectionAndAnnotationLab;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class P03HighQualityMistakes {

    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;

        Method[] methods = clazz.getDeclaredMethods();

        Comparator<Method> comparator = Comparator.comparing(Method::getName);


        Set<Method> getters = new TreeSet<>(comparator);
        Set<Method> setters = new TreeSet<>(comparator);

        for (Method method : methods) {
            String methodName = method.getName();

            if (methodName.contains("get")) {
                getters.add(method);
            } else if (methodName.contains("set")) {
                setters.add(method);
            }
        }

        Set<Field> fields = Arrays.stream(clazz.getDeclaredFields())
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Field::getName))));

        for (Field field : fields) {
            int modifiers = field.getModifiers();

            if (!Modifier.isPrivate(modifiers)) {
                System.out.println(field.getName() + " must be private!");
            }
        }

        for (Method getter : getters) {
            int modifiers = getter.getModifiers();

            if (!Modifier.isPublic(modifiers)) {
                System.out.println(getter.getName() + " have to be public!");
            }
        }

        for (Method setter : setters) {
            int modifiers = setter.getModifiers();

            if (!Modifier.isPrivate(modifiers)) {
                System.out.println(setter.getName() + " have to be private!");
            }
        }

    }
}
