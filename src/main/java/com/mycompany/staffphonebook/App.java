package com.mycompany.staffphonebook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private static Scene mainScene, addPhoneScene;
    private static Stage primaryStage;
    private static DataHandler dataHandler;

    @Override
    public void start(Stage stage) throws Exception {
        dataHandler = new DataHandler("staffphone.txt");

        Parent mainRoot = FXMLLoader.load(getClass().getResource("mainScene.fxml"));
        Parent addPhoneRoot = FXMLLoader.load(getClass().getResource("addPhoneScene.fxml"));

        mainScene = new Scene(mainRoot);
        addPhoneScene = new Scene(addPhoneRoot);

        primaryStage = stage;
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void changeScene(int sceneNumber) {
        if (sceneNumber == 0) {
            primaryStage.setScene(mainScene);
        } else {
            primaryStage.setScene(addPhoneScene);
        }
    }

    public static DataHandler getDataHandler() {
        return dataHandler;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
