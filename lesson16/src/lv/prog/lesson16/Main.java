package lv.prog.lesson16;

import lv.prog.lesson16.exceptions.QuadExceptions;

public class Main {

    public static void main(String[] args) throws QuadExceptions {
        QuadraticFunction quad = new QuadraticFunction(new ConsoleProvider());
        QuadRoots roots = quad.calculate();

        System.out.format("x1 = %.2f и x2 = %.2f", roots.getX1(), roots.getX2());
    }
}
