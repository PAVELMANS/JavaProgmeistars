package com.pivanovs;

import java.io.File;

public class printTree {
    public static void printBranch(String f, int tabulation) {
        File dir = new File(f);
        String tabulationSpace = "";
        for (int i = 0; i < tabulation; i++) {
            tabulationSpace += "\t";
        }
        tabulation++;
        System.out.println(tabulationSpace + dir.getName());
        tabulationSpace += "\t";

        //String[] list = dir.list();
        for (File file : dir.listFiles()) {
            if ( file.isDirectory()) {
                printBranch(file.getPath(), tabulation);
            } else {
                System.out.println(tabulationSpace + file.getName());
            }
        }
    }
}
