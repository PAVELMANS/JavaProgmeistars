package com.pivanovs;

public class TwoThreadsDoStuff {

    static class MyNumberRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println("The current thread - " + Thread.currentThread().getName() + " prints out " + i);
            }
        }
    }

    public static void printTwo() {
        MyNumberRunnable mnr = new MyNumberRunnable();
        Thread first = new Thread(mnr);
        Thread second = new Thread(mnr);
        first.setName("FIRST");
        second.setName("SECOND");
        first.start();
        second.start();
    }

}
