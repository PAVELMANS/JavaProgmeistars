package com.pivanovs;

public class Main {

    public static String codeCaesar(String input) {
        String output = "";
        for (char iCh : input.toCharArray()) {
            if (Character.isLetter(iCh)) {
                int codeICh = (int) iCh;
                if (((codeICh >= 88) && (codeICh <= 90)) || ((codeICh >= 120) && (codeICh <= 122))) {
                    output += (char) (codeICh - 23);
                } else {
                    output += (char) (codeICh + 3);
                }
            }
        }
        return output;
    }

    public static String codeVigenere(String input, String keyWord) {
        String output = "";
        input = input.toUpperCase();
        keyWord = keyWord.toUpperCase();
        if (keyWord.length() < input.length()) {
            String newKeyWord = keyWord;
            for (int i = 0; i < (input.length() / keyWord.length()) + 1; i++) {
                newKeyWord += keyWord;
            }
            keyWord = newKeyWord;
            System.out.println(keyWord);
        }

        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i))) {
                int codeICh = (int) input.charAt(i);
                int codeKeyCh = (int) keyWord.charAt(i);
                output += (char) (((codeICh - 65) + (codeKeyCh - 65)) % 26 + 65);
            }
        }
        return output;
    }

    public static String codePlayfair(String input, String keyWord) {

    }

    public static void main(String[] args) {

        String input = "Hello, world!";
        System.out.println(codeCaesar("abc"));
        input = "attackatdawn";
        String keyWord = "lemon";
        System.out.println(codeVigenere(input, keyWord));
    }
}
