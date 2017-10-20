package com.pivanovs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Sorting {

    public static File sortFile(String path) {
        try {
            File file = new File(path);
            BufferedReader bf = new BufferedReader(new FileReader(file));
            if (bf.lines().count() > 1) {

            }
        } catch (FileNotFoundException ex) {}
    }

}
