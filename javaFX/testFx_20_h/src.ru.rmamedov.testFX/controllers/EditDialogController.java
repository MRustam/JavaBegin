package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import objects.Person;

public class EditDialogController {

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldPhone;

    @FXML
    private Button buttonOK;

    @FXML
    private Button buttonCancel;

    private Person person;

    public EditDialogController() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
        textFieldName.setText(person.getName());
        textFieldPhone.setText(person.getPhoneNumber());
    }

    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node)actionEvent.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.hide();
    }

    public void actionOk(ActionEvent actionEvent) {
        person.setName(textFieldName.getText());
        person.setPhoneNumber(textFieldPhone.getText());
        actionClose(actionEvent);
    }
}
