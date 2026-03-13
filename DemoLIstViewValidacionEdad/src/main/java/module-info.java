module com.example.demolistview {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.demolistviewvalidacionedad to javafx.fxml;
    opens com.example.demolistviewvalidacionedad.controllers to javafx.fxml;
    opens com.example.demolistviewvalidacionedad.repositories to javafx.fxml;
    opens com.example.demolistviewvalidacionedad.services to javafx.fxml;

    exports com.example.demolistviewvalidacionedad;
    exports com.example.demolistviewvalidacionedad.repositories;
    exports com.example.demolistviewvalidacionedad.services;
    exports com.example.demolistviewvalidacionedad.controllers;

}