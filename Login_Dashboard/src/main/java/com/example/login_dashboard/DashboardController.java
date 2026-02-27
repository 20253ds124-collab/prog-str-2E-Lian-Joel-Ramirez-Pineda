package com.example.login_dashboard;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML
    private Label lblBienvenida;

    public void setUsuario(String usuario) {
        lblBienvenida.setText("Bienvenido, " + usuario);
    }
}
