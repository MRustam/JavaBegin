package controllers;

import implementations.AddressBookCollection;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import objects.Person;

import java.io.IOException;

public class MainController {

    AddressBookCollection addressBookCollection = new AddressBookCollection();

    @FXML
    public TableView tableAddressBook;
    @FXML
    public TableColumn columnName;
    @FXML
    public TableColumn columnPhone;
    @FXML
    public Label labelCounter;
    @FXML
    private TextField textFieldSearch;
    @FXML
    private Button buttonSearch;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonUpdate;
    @FXML
    private Button buttonDelete;

    private Parent root;
    private FXMLLoader loader = new FXMLLoader();
    private EditDialogConroller editDialogConroller;
    private Stage stage;

    @FXML
    public void initialize() {
        columnName.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("phoneNumber"));

        addressBookCollection.getPersonsList().addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> c) {
                updateCounter();
            }
        });

        addressBookCollection.fillData();

        tableAddressBook.setItems(addressBookCollection.getPersonsList());

        try {
            loader.setLocation(getClass().getResource("../fxml/editPane.fxml"));
            root = loader.load();
            editDialogConroller = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCounter() {
        labelCounter.setText("Count of items: " + addressBookCollection.getPersonsList().size());
    }

    public void buttonPressed(ActionEvent actionEvent) {

        Object source = actionEvent.getSource();

        if (!(source instanceof Button)) {
            return;
        }

        Button clickedButton = (Button) source;
        Person selectedPerson = (Person) tableAddressBook.getSelectionModel().getSelectedItem();
        Window parentWindow = ((Node)actionEvent.getSource()).getScene().getWindow();

        editDialogConroller.setPerson(selectedPerson);

        switch (clickedButton.getId()) {

            case "buttonAdd":

                break;
            case "buttonUpdate":
                showDialog(parentWindow);
                break;
            case "buttonDelete":

                break;
        }
    }

    private void showDialog(Window parentWindow) {
        if (stage == null) {
            stage = new Stage();
            stage.setTitle("edit panel");
            stage.setMinHeight(197);
            stage.setMinWidth(396);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(parentWindow);
        }
        stage.show();
    }
}
