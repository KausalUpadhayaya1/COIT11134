package com.mycompany.staffphonebook;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.application.Platform;

public class MainSceneController implements Initializable {

    @FXML
    private TextArea txtOutput;
    @FXML
    private Button btnDisplay;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnExit;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }

    // Display all phone numbers
    @FXML
    private void displayAction(ActionEvent event) {
        txtOutput.setText(App.getDataHandler().getDisplayOutput());
    }

    // Switch to Add Phone Scene
    @FXML
    private void addAction(ActionEvent event) {
        App.changeScene(1);  // Switch to AddPhoneScene
    }

    // Clear the text area
    @FXML
    private void clearAction(ActionEvent event) {
        txtOutput.setText("");  // Clear the output
    }

    // Save phone numbers to file
    @FXML
    private void saveAction(ActionEvent event) {
        App.getDataHandler().saveData();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Save Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Phone numbers saved successfully!");
        alert.showAndWait();
    }

    // Exit the application with confirmation
    @FXML
    private void exitAction(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to close?");
        alert.showAndWait().ifPresent(response -> {
            if (response.getButtonData().isDefaultButton()) {
                Platform.exit();  // Exit the application
            }
        });
    }
}
