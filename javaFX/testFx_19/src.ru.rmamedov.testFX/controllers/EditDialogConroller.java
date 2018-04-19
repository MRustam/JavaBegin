package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import objects.Person;

public class EditDialogConroller {

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldPhone;

    @FXML
    private Button buttonOK;

    @FXML
    private Button buttonCancel;

    private Person person;

    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node)actionEvent.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.close();
    }

    public void setPerson(Person person) {
        this.person = person;
        textFieldName.setText(person.getName());
        textFieldPhone.setText(person.getPhoneNumber());
    }
}
