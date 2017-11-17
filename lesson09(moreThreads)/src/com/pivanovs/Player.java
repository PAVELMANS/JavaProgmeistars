package com.pivanovs;

public class Player extends Thread {

    private int amountSt;
    private int guess;
    private int anotherSt;


    static void test(){

    }

    public synchronized void start(int n) {
        amountSt = n;
        guess = 0;
    }

    public int getAmountSt() {
        return amountSt;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public void decAmountSt() {
        amountSt--;
    }

    public void setAnotherSt(Player a) {
         anotherSt = a.getAmountSt();
    }

    public int getAnotherSt() {
        return anotherSt;
    }
}
