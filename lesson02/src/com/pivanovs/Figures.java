package com.pivanovs;

public class Figures {

    class Point {
        int x, y;

        public Point(int x0, int y0) {
            this.x = x0;
            this.y = y0;
        }
    }

    interface Shape {

        void tellAboutYourself();

    }

    public class Rectangle implements Shape {

        Point pointA;
        Point pointB;

        @Override
        public void tellAboutYourself() {
            System.out.println("paint rectangle, point 1 (" + pointA.x + ", " + pointA.y + "), point 2 (" + pointB.x + ", " + pointB.y + ")");
        }
    }

    public class Circle implements Shape {

        Point centre;
        int diameter;

        @Override
        public void tellAboutYourself() {
            System.out.println("paint circle, centre (" + centre.x + ", " + centre.y + ") and diameter (" + diameter + ")");
        }
    }

    public class Square implements Shape {
        Point a;
        int length;

        @Override
        public void tellAboutYourself() {
            System.out.println("paint square, upper left point (" + a.x + ", " + a.y + ") and the length (" + length + ")");
        }
    }

    public void main() {
        Point a = new Point(10, 20);
        Point b = new Point(15, 35);
        Rectangle r = new Rectangle();
        r.pointA = a;
        r.pointB = b;
        r.tellAboutYourself();
        Circle c = new Circle();
        c.centre = a;
        c.diameter = 10;
        c.tellAboutYourself();
        Square s = new Square();
        s.a = a;
        s.length = 12;
        s.tellAboutYourself();
    }

}
