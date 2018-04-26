package start;

import controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        ResourceBundle bundle;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../fxml/main.fxml"));
        FileInputStream fis = new FileInputStream("/Users/rustam/programming/java/JavaBegin/javaFX/testFx_21_my/src/ru.rmamedov.testFX/bundles/Locale_en.properties");
        bundle = new PropertyResourceBundle(fis);
        loader.setResources(bundle);

        Parent root = loader.load();
        MainController mainController = loader.getController();
        mainController.setStageMain(primaryStage);

        primaryStage.setTitle(loader.getResources().getString("title"));
        primaryStage.setMinWidth(600);
        primaryStage.setMinHeight(390);
        primaryStage.setScene(new Scene(root, 600, 390));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
