package com.pivanovs;

import java.io.File;

import static com.pivanovs.printTree.printBranch;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("This program prints out tree of the directory");
        System.out.println();
        try {
            File f = new File("D:\\Pavels Ivanovs");
            printBranch(f.getPath(), 0);
        } catch (NullPointerException ex) {}
    }
}
