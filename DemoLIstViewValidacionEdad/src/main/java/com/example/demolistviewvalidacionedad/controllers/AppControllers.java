package com.example.demolistviewvalidacionedad.controllers;


import com.example.demolistviewvalidacionedad.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class AppControllers {
    @FXML
    private Label lblMsg;
    @FXML
    private ListView<String> listView;

    @FXML
    private TextField txtName;

    @FXML
     private TextField txtEmail;

    @FXML
    private TextField txtAge;



    @FXML
    private ObservableList<String> data= FXCollections.observableArrayList();

    private PersonService service = new PersonService();

    @FXML
    public void initialize(){
        loadFromFile();
        listView.setItems(data);
    }

    @FXML
    public void onReload(){
        loadFromFile();
    }

    @FXML
    public void onAdd(){
        try {
            String name=txtName.getText();
            String email=txtEmail.getText();
            String ageText=txtAge.getText();
            int age = Integer.parseInt(ageText);
            service.addPerson(name, email, age);


            service.addPerson(name, email, age);
            lblMsg.setText("Persona creada con exito");
            lblMsg.setStyle("-fx-text-fill: green");
            txtEmail.clear();
            txtName.clear();
            txtAge.clear();

            loadFromFile();
        }catch (NumberFormatException e){
            lblMsg.setText("La edad debe ser +18");
            lblMsg.setStyle("-fx-text-fill: red");

        } catch (IOException e){
            lblMsg.setText("Hubo un error con el archivo");
            lblMsg.setStyle("-fx-text-fill: red");

        }catch (IllegalArgumentException e){
            lblMsg.setText("Hubo un error "+e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");

        }


    }
    private void loadFromFile(){
        try{
            List<String> items = service.loadDataForListView();
            data.setAll(items);
            lblMsg.setText("Datos cargados con exito");
            lblMsg.setStyle("-fx-text-fill: green");
        }catch (IOException e){
            lblMsg.setText("Error al cargar los archivos");
            lblMsg.setStyle("-fx-text-fill: red");
        }

    }
}
