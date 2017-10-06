package com.pivanovs;

public class Figures {

    class Point {
        int x, y;

        public Point(int x0, int y0) {
            this.x = x0;
            this.y = y0;
        }
    }

    class Shape {
        abstract void tellAboutYourself();
    }

    public class Rectangle extends Shape {
        void tellAboutYourself(Point pointA, Point pointB) {
            System.out.println("paint rectangle, point 1 (" + pointA.x + ", " + pointA.y + "), point 2 (" + pointB.x + ", " + pointB.y + ")");
        }
    }

    public class Circle extends Shape {
        void tellAboutYourself(Point centre, int diameter) {
            System.out.println("paint circle, centre (" + centre.x + ", " + centre.y + ") and diameter (" + diameter + ")");
        }
    }

    public class Square extends Shape {
        void tellAboutYourself(Point a, int length) {
            System.out.println("paint square, upper left point (" + a.x + ", " + a.y + ") and the length (" + length + ")");
        }
    }

    public void main(String args[]) {
        Point a = new Point(10, 20);
        Point b = new Point(15, 35);
        Rectangle r = new Rectangle();
        r.tellAboutYourself(a, b);
        Circle c = new Circle();
        c.tellAboutYourself(b, 15);
        Square s = new Square();
        s.tellAboutYourself(a, 5);
    }

}
