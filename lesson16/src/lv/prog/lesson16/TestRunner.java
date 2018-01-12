package lv.prog.lesson16;

import lv.prog.lesson16.test.QuadraticFunctionTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestRunner {

    private static boolean ifHasTestAnnotation(Method method) {
        for (Annotation annotation : method.getDeclaredAnnotations()) {
            if (annotation.annotationType().getSimpleName().equals("Test")) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        List<Class> tests = new LinkedList<>();
        tests.add(QuadraticFunctionTest.class);

        for (Class t : tests) {
            System.out.println("Протестируй меня - " + t.getSimpleName());
            Method[] methods = t.getMethods();
            Arrays.stream(methods)
                    .filter(TestRunner::ifHasTestAnnotation)
                    .forEach(method -> {
                        try {
                            method.invoke(t.newInstance());
                        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }
}
