package com.pivanovs;

import java.util.Random;
import java.util.Scanner;

public class ThreadyStones {

    Random rand = new Random();

    class Player1 extends Player {
        //private int amountSt;
        //private int guess;

        @Override
        public void run() {
            while (this.getAmountSt() > 0) {
                synchronized (ThreadyStones.class) {
                    this.setGuess(rand.nextInt(this.getAmountSt() + this.getAnotherSt()));
                    try {
                        ThreadyStones.class.notify();
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @Override
        public synchronized void start(int n) {
            super.start(n);
        }
    }

    class Player2 extends Player {
        //private int amountSt;
        //private int guess;

        @Override
        public void run() {
            while (this.getAmountSt() > 0) {
                synchronized (ThreadyStones.class) {
                    this.setGuess(rand.nextInt(this.getAnotherSt() + this.getAmountSt()));
                    try {
                        ThreadyStones.class.notify();
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @Override
        public synchronized void start(int n) {
            super.start(n);
        }

    }

    public void playDaStonyGame() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the amount of stones you want each player to have: ");
        int amountOfStones = input.nextInt();

        Player1 player1 = new Player1();
        Player2 player2 = new Player2();

        player1.start(amountOfStones);
        player2.start(amountOfStones);

        do {
            synchronized (this) {
                player1.setAnotherSt(player2);
                player2.setAnotherSt(player1);
                try {
                    wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            int sum = player1.getAmountSt() + player2.getAmountSt();
            System.out.println("Total amount of stones is: " + sum);

            while (player1.getGuess() == player2.getGuess()) {
                System.out.println("Both players guessed the same number!");
                notifyAll();
            }

            System.out.println("Player1 guess is " + player1.getGuess());
            System.out.println("Player2 guess is " + player2.getGuess());

            if (player1.getGuess() == sum) {
                System.out.println("Player1 made a right guess!");
                player1.decAmountSt();
            } else if (player2.getGuess() == sum) {
                System.out.println("Player2 made a right guess!");
                player2.decAmountSt();
            }
            notifyAll();
        } while ((player1.getAmountSt() > 0) && (player2.getAmountSt() > 0));
    }
}
