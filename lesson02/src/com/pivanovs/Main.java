package com.pivanovs;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Random rand = new Random();

    static class Stones {
        int stoneAmL, stoneAmR, previousWinner;
    }

    private static Stones play(Stones st) {

        System.out.println("Player 1 has " + st.stoneAmL + " stone(s) and player 2 has " + st.stoneAmR + " stone(s)");

        int stonesTaken = rand.nextInt(st.stoneAmL + 1) + rand.nextInt(st.stoneAmR + 1);
        System.out.println("They take together " + stonesTaken + " stone(s)");
        int guessW = rand.nextInt(st.stoneAmL + st.stoneAmR + 1);
        System.out.println("Player " + (st.previousWinner + 1) + " makes his guess of " + guessW);
        int guessL;
        do {
            guessL = rand.nextInt(st.stoneAmL + st.stoneAmR + 1);
        } while (guessL == guessW);
        System.out.println("Player " + (2 - st.previousWinner) + " makes his guess of " + guessL);

        if (guessW == stonesTaken) {
            if (st.previousWinner == 0) {
                st.stoneAmL -= 1;
            } else {
                st.stoneAmR -= 1;
            }
        } else  if (guessL == stonesTaken){
            if (st.previousWinner == 0) {
                st.stoneAmR -= 1;
                st.previousWinner = 1;
            } else {
                st.stoneAmL -= 1;
                st.previousWinner = 0;
            }
        }
        return st;
    }

    public static void main(String args[]) {
        System.out.print("Please enter the amount of stones you would like each player to have: ");
        Scanner putIn = new Scanner(System.in);
        Stones st = new Stones();
        st.stoneAmL = putIn.nextInt();
        st.stoneAmR = st.stoneAmL;
        st.previousWinner = rand.nextInt(2);
        //Integer stoneAmL = putIn.nextInt();
        //Integer stoneAmR = stoneAmL;

        //Integer previousWinner = rand.nextInt(2);

        do {
            st = play(st);
        } while ((st.stoneAmL > 0) && (st.stoneAmR > 0));

        System.out.println("The game has ended. Last winner is player " + (st.previousWinner + 1));
    }

}
