package com.pivanovs;

import java.util.ArrayList;
import java.util.Scanner;

public class JosephusProblem {

    public static int play(int amount, int n) {

        if (amount == 1) {
            return 1;
        }

        ArrayList<Integer> list = new ArrayList<>();

        if (n < 0) {
            n = -n;
            for (int i = amount; i >= 1; i--) {
                list.add(i);
            }
        } else {
            for (int i = 1; i <= amount; i++) {
                list.add(i);
            }
        }

        int i = (n - 1) % list.size();
        do {
            list.remove(i);
            i = (i + n - 1) % list.size();
        } while (list.size() > 1);

        return list.get(0);

    }

    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the amount of objects: ");
        int amount = input.nextInt();
        System.out.print("Please enter the n, that every nth object will be eliminated: ");
        int n = input.nextInt();


        try {
            System.out.println("The last remaining object is " + play(amount, n) + "th");
        } catch (ArithmeticException e) {
            System.out.println("You have probably made amount equal to 0 or entered a negative amount, which are bad things to do :(");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("n cannot be zero");
        }
    }

}
