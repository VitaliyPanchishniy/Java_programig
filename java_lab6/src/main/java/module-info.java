module com.example.java_lab6 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.java_lab6.view to javafx.fxml;

    exports com.example.java_lab6;
    exports com.example.java_lab6.view;
}
