package ru.rmamedov.testFX.start;

import ru.rmamedov.testFX.controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {

    private static final Locale DEFAULT_LOCALE = new Locale("ru");

    @Override
    public void start(Stage primaryStage) throws Exception {

        Locale.setDefault(DEFAULT_LOCALE);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../fxml/main.fxml"));
        loader.setResources(ResourceBundle.getBundle("ru.rmamedov.testFX.bundles.Locale"));

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
