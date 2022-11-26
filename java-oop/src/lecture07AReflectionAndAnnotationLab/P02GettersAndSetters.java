package lecture07AReflectionAndAnnotationLab;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class P02GettersAndSetters {

    public static void main(String[] args) throws NoSuchMethodException {

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

        for (Method getter : getters) {
            System.out.println(getter.getName() + " will return class " + getter.getReturnType().getName());
        }

        for (Method setter : setters) {
            System.out.println(setter.getName() + " and will set field of class " + setter.getParameterTypes()[0].getName());
        }
        
    }
}
