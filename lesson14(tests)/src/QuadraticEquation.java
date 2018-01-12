//import java.util.Scanner;

public class QuadraticEquation {

    private double a;
    private double b;
    private double c;
    private double discriminant;
    private  double x1;
    private double x2;

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    //public static void Parse(String a, String b, String c) {

    //}

    public QuadraticEquation(String a, String b, String c) {
        try {
            this.a = Float.parseFloat(a);
            this.b = Float.parseFloat(b);
            this.c = Float.parseFloat(c);
            discriminant = getDiscriminant(this.a, this.b, this.c);
        } catch (NumberFormatException e) {
            System.out.println("Things you've entered are not numbers!");
        }
    }

    public void calculate() {
        if (discriminant >= 0) {
            try {
                x1 = (-b + Math.sqrt(discriminant)) / 2 * a;
                System.out.println("The root of the equation is " + x1);
                x2 = ((-b - Math.sqrt(discriminant)) / 2 * a);
                System.out.println("And another root of the equation is " + x2);
            } catch (ArithmeticException e) {
                System.out.println("the discriminant is negative(");
            }
        }
    }

    double getDiscriminant(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            System.out.println("THIS EQUATION HAS NO REAL SOLUTION");
        }
        return discriminant;
    }

    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("please enter the a: ");
        double a = in.nextFloat();
        System.out.print("please enter the b: ");
        double b = in.nextFloat();
        System.out.print("please enter the c: ");
        double c = in.nextFloat();
        QuadraticEquation qe = new QuadraticEquation(a, b, c);
        qe.calculate();
    }*/

}
