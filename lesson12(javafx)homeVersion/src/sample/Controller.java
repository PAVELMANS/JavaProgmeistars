package sample;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Controller {
    public TextField pathField;
    public Button openFileButton;
    public TextArea textArea;
    public Button closeButton;
    public Button writeButton;
    private File file;
    private PrintWriter pw;
    private BufferedReader br;

    public void readTextFromFile(MouseEvent mouseEvent) {
        try {
            String path = pathField.getText();
            file = new File(path);

            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);
            List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
            while (!lines.isEmpty()) {
                textArea.setText(textArea.getText() + lines.get(0));
                lines.remove(0);
            }
        } catch (IOException e) {
            textArea.setText("THERE IS NO SUCH FILE\n\r" +
                    "OR THERE IS SOMETHING WRONG!");
        }
        writeButton.setDisable(false);
    }

    public void closeWindow(MouseEvent mouseEvent) throws IOException {
        pw.flush();
        pw.close();
        br.close();
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void writeTextIntoFile(MouseEvent mouseEvent) {
        try {
            FileWriter fw = new FileWriter(file);
            pw = new PrintWriter(fw);
            pw.write(textArea.getText().replaceAll("\n", "\r\n"));
            pw.flush();
        } catch (IOException e) {}
    }
}
