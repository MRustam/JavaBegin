package start;

import controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../fxml/main.fxml"));
        Parent root = loader.load();
        MainController mainController = loader.getController();
        mainController.setStageMain(primaryStage);

        primaryStage.setTitle("Address book");
        primaryStage.setMinWidth(600);
        primaryStage.setMinHeight(390);
        primaryStage.setScene(new Scene(root, 600, 390));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
