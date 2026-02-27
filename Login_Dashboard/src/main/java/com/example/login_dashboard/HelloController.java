package com.example.login_dashboard;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class HelloController {

    @FXML
    private TextField txtCorreo;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblError;

    @FXML
    protected void handleLogin() {
        String correo = txtCorreo.getText();
        String password = txtPassword.getText();

        if (correo.isEmpty() || correo.length() < 4) {
            lblError.setText("Usa mínimo 4 caracteres");
            return;
        }
        if (!correo.contains("@") || !correo.contains(".")) {
            lblError.setText("Correo inválido");
            return;
        }
        if (password.length() < 6) {
            lblError.setText("Usa mínimo 6 caracteres");
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard-view.fxml"));
            Parent root = loader.load();

            DashboardController controller = loader.getController();
            controller.setUsuario(correo);

            Stage stage = (Stage) txtCorreo.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
