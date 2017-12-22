package sample;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {
    public Button joinButton;
    public TextField portField;
    public TextField nicknameField;

    public void join(MouseEvent mouseEvent) {
        String nickname = nicknameField.getText();
        String portS = portField.getText();
        if (!nickname.isEmpty() && !portS.isEmpty()) {

        }
    }
}
