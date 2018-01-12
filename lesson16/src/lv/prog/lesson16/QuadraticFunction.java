package lv.prog.lesson16;

import lv.prog.lesson16.exceptions.AisZero;
import lv.prog.lesson16.exceptions.RootsAreNotReal;

public class QuadraticFunction {

    private InputProvider inputProvider;

    public QuadraticFunction(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    public QuadRoots calculate() {
        double a = inputProvider.provideA();
        double b = inputProvider.provideB();
        double c = inputProvider.provideC();

        double x1;
        double x2;

        if (a == 0){
            throw new AisZero();
        }

        double determinant = b * b - 4 * a * c;

        //condition for real and different roots
        if (determinant > 0) {
            x1 = (-b + Math.sqrt(determinant)) / (2 * a);
            x2 = (-b - Math.sqrt(determinant)) / (2 * a);
        } else if (determinant == 0) { // Condition for real and equal roots
            x1 = x2 = -b / (2 * a);
        } else {
            throw new RootsAreNotReal();
        }

        return new QuadRoots(x1, x2);

    }
}
