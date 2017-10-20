package com.pivanovs;

public class Main {

    static char[][] matrix = new char[5][5];
    static char[][] matrixX = new char[5][5];

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
        }

        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i))) {
                int codeICh = (int) input.charAt(i);
                int codeKeyCh = (int) keyWord.charAt(i);
                output += (char) (((codeICh - 65) + (codeKeyCh - 65)) % 26 + 65);
            } else {
                output += input.charAt(i);
            }
        }
        return output;
    }

    public static Point findInMatrix(char ch) {
        Point res;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == ch) {
                    res = new Point(i, j);
                    return res;
                }
            }
        }
        res = new Point(5, 5);
        return res;
    }

    public static String codePlayfair(String input, String keyWord) {
        String output = "";
        input = input.toUpperCase().replaceAll(" ", "");
        keyWord = keyWord.toUpperCase();

        //matricas konstruēšana
        String abc = "";
        for (int i = 65; i < 91; i++) {
            if (i == 74) {
                continue;
            }
            abc += (char) i;
        }
        char temp;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (keyWord.length() > 0) {
                    matrix[i][j] = keyWord.charAt(0);
                    temp = keyWord.charAt(0);
                    abc = abc.replaceAll(Character.toString(temp), "");
                    keyWord = keyWord.replaceAll(Character.toString(temp), "");
                    if (temp == 'I') {
                        abc = abc.replaceAll("J", "");
                        keyWord = keyWord.replaceAll("J", "");
                    } else if (temp == 'J') {
                        abc = abc.replaceAll("I", "");
                        keyWord = keyWord.replaceAll("I", "");
                    }
                } else {
                    matrix[i][j] = abc.charAt(0);
                    abc = abc.substring(1);
                }
            }
        }

        //šifrēšana
        //input vārda sadalīšana bīgrammās
        while (!input.isEmpty()) {
            if (input.length() == 1) {
                input += "X";
            }
            if (input.charAt(0) == input.charAt(1)) {
                input = input.charAt(0) + "X" + input.substring(1);
            }
            Point pCh0 = findInMatrix(input.charAt(0));
            Point pCh1 = findInMatrix(input.charAt(1));

            if (pCh0.i == pCh1.i) {  //ja vienā rindā
                int row = pCh0.i;
                if (pCh0.j == 4) {
                    output += matrix[row][0];
                } else {
                    output += matrix[row][pCh0.j + 1];
                }
                if (pCh1.j == 4) {
                    output += matrix[row][0];
                } else {
                    output += matrix[row][pCh1.j + 1];
                }
            } else if (pCh0.j == pCh1.j) {  //ja vienā kolonnā
                int column = pCh0.j;
                if (pCh0.i == 4) {
                    output += matrix[0][column];
                } else {
                    output += matrix[pCh0.i + 1][column];
                }
                if (pCh1.i == 4) {
                    output += matrix[0][column];
                } else {
                    output += matrix[pCh1.i + 1][column];
                }
            } else { //pēc taisnstūra leņķiem
                output += matrix[pCh0.i][pCh1.j];
                output += matrix[pCh1.i][pCh0.j];
            }

            if (input.length() > 2) {
                input = input.substring(2);
            } else {
                input = "";
            }
        }

        return output;
    }

    public static Point findInMatrixX(char ch) {
        Point res;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrixX[i][j] == ch) {
                    res = new Point(i, j);
                    return res;
                }
            }
        }
        res = new Point(0, 0);
        return res;
    }

    public static String codePolybius(String input) {
        String result = "";
        input = input.toUpperCase();

        //making the matrixX
        int chIndex = 64;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                chIndex++;
                if (((char) chIndex == 'J') || ((char) chIndex == 'I')) {
                    matrixX[i][j] = 'I';
                    chIndex++;
                } else {
                    matrixX[i][j] = (char) chIndex;
                }
                //System.out.println(matrixX[i][j]);
            }
        }

        //first method
        Point pCh;
        for (int i = 0; i < input.length(); i++) {
            pCh = findInMatrixX(input.charAt(i));
            if (pCh.i != 4) {
                result += matrixX[pCh.i + 1][pCh.j];
            } else {
                result += matrixX[0][pCh.j];
            }
        }
        System.out.println("Result of the first method: " + result);
        result = "";
        return result;
    }

    public static void main(String[] args) {

        String input = "Hello, world!";
        System.out.println(codeCaesar("abc"));
        input = "IDIOCY OFTEN LOOKS LIKE INTELLIGENCE";
        String keyWord = "Wheatson";
        System.out.println(codeVigenere(input, keyWord));
        System.out.println(codePlayfair(input, keyWord));
        System.out.println(codePolybius("sometext"));
    }

    public static class Point {
        int i, j;

        Point(int x0, int y0) {
            i = x0;
            j = y0;
        }
    }
}
