module com.mycompany.staffphonebook {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.staffphonebook to javafx.fxml;
    exports com.mycompany.staffphonebook;
}
