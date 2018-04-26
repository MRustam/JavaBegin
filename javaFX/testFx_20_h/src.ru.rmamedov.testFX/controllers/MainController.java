package controllers;

import implementations.AddressBookCollection;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
    private EditDialogController editDialogController;
    private Stage stageEdit;
    private Stage stageMain;


    public void setStageMain(Stage stageMain) {
        this.stageMain = stageMain;
    }

    @FXML
    public void initialize() {
        columnName.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("phoneNumber"));
        initListeners();
        initFillData();
        initLoader();
    }

    private void initLoader() {
        try {
            loader.setLocation(getClass().getResource("../fxml/editPane.fxml"));
            root = loader.load();
            editDialogController = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initFillData() {
        addressBookCollection.fillData();
        tableAddressBook.setItems(addressBookCollection.getPersonsList());
    }

    private void initListeners() {
        addressBookCollection.getPersonsList().addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> c) {
                updateCounter();
            }
        });
        tableAddressBook.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    editDialogController.setPerson((Person) tableAddressBook.getSelectionModel().getSelectedItem());
                    showDialog();
                }
            }
        });
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

        editDialogController.setPerson(selectedPerson);

        switch (clickedButton.getId()) {

            case "buttonAdd":
                editDialogController.setPerson(new Person());
                showDialog();
                addressBookCollection.add(editDialogController.getPerson());
                break;
            case "buttonUpdate":
                editDialogController.setPerson((Person) tableAddressBook.getSelectionModel().getSelectedItem());
                showDialog();
                break;
            case "buttonDelete":
                addressBookCollection.delete((Person) tableAddressBook.getSelectionModel().getSelectedItem());
                break;
        }
    }

    private void showDialog() {
        if (stageEdit == null) {
            stageEdit = new Stage();
            stageEdit.setTitle("edit panel");
            stageEdit.setMinHeight(197);
            stageEdit.setMinWidth(396);
            stageEdit.setResizable(false);
            stageEdit.setScene(new Scene(root));
            stageEdit.initModality(Modality.WINDOW_MODAL);
            stageEdit.initOwner(stageMain);
        }
        stageEdit.showAndWait();
    }
}
