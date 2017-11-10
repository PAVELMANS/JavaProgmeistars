package com.pivanovs;

import java.util.*;

public class ComparableAndCompareTo {

    static class TestClass {
        private int n;

        public TestClass(int n1) {
            this.n = n1;
        }

        public int getN() {
            return this.n;
        }

        public void setN(int n) {
            this.n = n;
        }
    }

    static class ComparatorOfTestClass implements Comparator<TestClass> {
        public int compare(TestClass tc1, TestClass tc2) {
            return Integer.compare(tc1.getN(), tc2.getN());
        }
    }

    public static void sorting() {

        List<TestClass> list = new ArrayList<>();

        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(new TestClass(rand.nextInt(21)));
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(list.get(i).getN() + " ");
        }
        System.out.println();
        ComparatorOfTestClass comparalka = new ComparatorOfTestClass();
        Collections.sort(list, comparalka);

        for (int i = 0; i < 10; i++) {
            System.out.print(list.get(i).getN() + " ");
        }
    }

}
