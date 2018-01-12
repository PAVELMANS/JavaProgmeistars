package lv.prog.lesson16;

import java.util.Scanner;

public class ConsoleProvider implements InputProvider {

    private Scanner scanner;

    private boolean greeted = false;

    public ConsoleProvider() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public double provideA() {
        return this.readNumberArg("A");
    }

    @Override
    public double provideB() {
        return this.readNumberArg("B");
    }

    @Override
    public double provideC() {
        return this.readNumberArg("C");
    }

    private void welcome()
    {
        if (!this.greeted) {
            System.out.println("Решение квадратного уравнения");
            System.out.println("Введите коэффициенты");
            this.greeted = true;
        }
    }

    private double readNumberArg(String name) {
        this.welcome();

        while (true) {
            System.out.print(name + " = ");
            String as = this.scanner.nextLine();

            try {
                return Double.parseDouble(as);
            } catch (NumberFormatException e) {
                System.out.println("Не число");
            }
        }
    }
}
