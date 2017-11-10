package com.pivanovs;

import java.util.PriorityQueue;
import java.util.Queue;

public class GenericQueue {

    public static void main(String args[]) {

        PriorityQueue<Integer> q1 = new PriorityQueue<>();
        PriorityQueue<Integer> q2 = new PriorityQueue<>();
        Random rand = new Random();
        for (int i = 0; i < 8; i++) {
            q1.add(rand.nextInt(15));
        }
        System.out.println(q1.comparator());

        System.out.println("length of the first queue: ");
    }

}
