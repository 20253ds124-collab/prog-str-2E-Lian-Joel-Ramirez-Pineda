module com.example.login_dashboard {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.login_dashboard to javafx.fxml;
    exports com.example.login_dashboard;
}