package com.mycompany.staffphonebook;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddPhoneSceneController implements Initializable {

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPhone;
    @FXML
    private Button btnSubmit;
    @FXML
    private Button btnCancel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    // Submit new phone number entry
    @FXML
    private void submitAction(ActionEvent event) {
        if (!txtName.getText().isEmpty() && !txtPhone.getText().isEmpty()) {
            PhoneNumber newPhoneNumber = new PhoneNumber(txtName.getText(), txtPhone.getText());
            App.getDataHandler().addPhoneNo(newPhoneNumber);
            
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Entry Added");
            alert.setHeaderText(null);
            alert.setContentText("New phone entry added successfully!");
            alert.showAndWait();
            
            App.changeScene(0);  // Switch back to main scene
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText(null);
            alert.setContentText("Both fields must be filled!");
            alert.showAndWait();
        }
    }

    // Cancel and return to main scene
    @FXML
    private void cancelAction(ActionEvent event) {
        App.changeScene(0);  // Switch back to main scene
    }
}
