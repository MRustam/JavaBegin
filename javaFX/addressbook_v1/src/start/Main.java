package start;

import implementations.AddressBookCollection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import objects.Person;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/main.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setMinWidth(600);
        primaryStage.setMinHeight(390);
        primaryStage.setScene(new Scene(root, 600, 390));
        primaryStage.show();

        test();
    }

    public void test() {

        AddressBookCollection addressBook = new AddressBookCollection();

        Person person1 = new Person("User1", "+8989");
        Person person2 = new Person("User2", "+0909");

        addressBook.add(person1);
        addressBook.add(person2);

        person1.setPhoneNumber("+0000");

        addressBook.delete(person1);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
