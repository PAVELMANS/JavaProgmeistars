package com.pivanovs;

import java.util.Scanner;
import java.util.Stack;

public class GenericStack {

    public static void main(String args[]) {
        Stack<Integer> myStack = new Stack<>();
        int n = new Scanner(System.in).nextInt();
        for (int i = 0; i < n; i++) {
            myStack.push(i);
            System.out.print(i + " ");
        }
        System.out.println();
        while (!myStack.empty()) {
            System.out.print(myStack.pop() + " ");
        }
    }

}
