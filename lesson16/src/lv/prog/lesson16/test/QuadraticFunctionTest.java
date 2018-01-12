package lv.prog.lesson16.test;

import lv.prog.lesson16.InputProvider;
import lv.prog.lesson16.QuadraticFunction;
import org.junit.jupiter.api.Test;

/**
 * ff IDEA cant find junit library:
 * alt+enter on "@Test" -> select something with "JUnit 5" & add it to project
 * IDEA will download it for you
 */
public class QuadraticFunctionTest {

    @Test
    public void calculate() {
        InputProvider mock = new InputProvider() {
            @Override
            public double provideA() {
                return 1;
            }

            @Override
            public double provideB() {
                return 6;
            }

            @Override
            public double provideC() {
                return 9;
            }
        };

        QuadraticFunction quadraticFunction = new QuadraticFunction(mock);

        if (quadraticFunction.calculate().getX1() != -3d) {
            throw new RuntimeException("X1 должен быть -3");
        }

        if (quadraticFunction.calculate().getX2() != -3d) {
            throw new RuntimeException("X2 должен быть -3");
        }
    }
}
