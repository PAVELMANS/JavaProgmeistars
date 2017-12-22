package sample;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.ServerSocket;

public class Controller extends Thread {

    public Label oppNickname;
    public Label serStones;
    public Label stonesBoth;
    public TextField serGuess;
    public Label resultLabel;

    public void makeAGuess(MouseEvent mouseEvent) {

    }

    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(9001)
        } catch (IOException e) {}

    }
}
