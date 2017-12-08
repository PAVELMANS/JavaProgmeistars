package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    public TextField inputField;
    public Button myButton;
    public ListView myListView;

    public void totalSwap(MouseEvent mouseEvent) {
        List<String> list = Arrays.asList(inputField.getText().split(" "));
        list = list.stream()
                .sorted()
                .collect(Collectors.toList());
        for (String s : list) {
            myListView.getItems().add(s);
        }
    }

}
