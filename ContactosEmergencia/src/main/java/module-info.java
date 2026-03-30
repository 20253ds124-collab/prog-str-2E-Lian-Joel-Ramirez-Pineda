module com.example.contactosemergencia {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.example.contactosemergencia;
    exports controller;
    exports model;

    opens com.example.contactosemergencia to javafx.fxml;
    opens controller to javafx.fxml;
    opens model to javafx.fxml;
}
