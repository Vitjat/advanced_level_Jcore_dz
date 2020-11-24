package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Controller {
    @FXML
    public TextArea textArea1;
    @FXML
    public TextField textField;

    public void onClickSend(ActionEvent actionEvent) {
        textArea1.appendText(textField.getText() + "\n");
        textField.clear();
        textField.requestFocus();
    }
    public void actionPerformed(ActionEvent e) {
        textArea1.appendText(textField.getText() + "\n");
        textField.clear();
        textField.requestFocus();
    }


}
