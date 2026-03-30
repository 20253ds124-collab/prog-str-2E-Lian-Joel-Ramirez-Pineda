package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Contacto;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML private TextField txtNombre;
    @FXML private TextField txtTelefono;
    @FXML private ComboBox<String> cmbParentesco;
    @FXML private ListView<Contacto> listContactos;

    private List<Contacto> contactos = new ArrayList<>();
    private String[] parentescos = {"Padre","Madre","Hermano","Hermana","Abuelo","Abuela","Tío","Tía"};

    @FXML
    public void initialize() {
        cmbParentesco.getItems().addAll(parentescos);
    }

    @FXML
    private void agregar() {
        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();
        String parentesco = cmbParentesco.getValue();

        if (nombre.isEmpty() || telefono.isEmpty() || parentesco == null) {
            mostrarAlerta("Todos los campos son obligatorios");
            return;
        }
        if (telefono.length() != 10) {
            mostrarAlerta("El teléfono debe tener 10 dígitos");
            return;
        }
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                mostrarAlerta("Ya existe un contacto con ese nombre");
                return;
            }
        }

        Contacto nuevo = new Contacto(nombre, telefono, parentesco);
        contactos.add(nuevo);
        refrescarLista();
        limpiar();
    }

    @FXML
    private void buscar() {
        String nombre = txtNombre.getText();
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                txtTelefono.setText(c.getTelefono());
                cmbParentesco.setValue(c.getParentesco());
                return;
            }
        }
        mostrarAlerta("Contacto no encontrado");
    }

    @FXML
    private void actualizar() {
        String nombre = txtNombre.getText();
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                c.setTelefono(txtTelefono.getText());
                c.setParentesco(cmbParentesco.getValue());
                refrescarLista();
                limpiar();
                return;
            }
        }
        mostrarAlerta("No se encontró el contacto para actualizar");
    }

    @FXML
    private void eliminar() {
        String nombre = txtNombre.getText();
        contactos.removeIf(c -> c.getNombre().equalsIgnoreCase(nombre));
        refrescarLista();
        limpiar();
    }

    @FXML
    private void limpiar() {
        txtNombre.clear();
        txtTelefono.clear();
        cmbParentesco.setValue(null);
    }

    private void refrescarLista() {
        listContactos.getItems().setAll(contactos);
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
