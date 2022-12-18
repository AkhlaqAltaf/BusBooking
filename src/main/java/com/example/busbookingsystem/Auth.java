package com.example.busbookingsystem;


import DB.DataBase;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.*;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Auth  implements Initializable {


 @FXML
 TextField getEmail,getPassword;
 @FXML
 private Label error=null;
 @FXML
 TextField setEmail,setPassword,setFirstName,setLastName,phone;
 @FXML
 private  ComboBox gender;
 @FXML
 private Label emailExist;



   @FXML
   private AnchorPane login;
    FXMLLoader loader;
    AnchorPane auth;
    @FXML
    DataBase db;
    @FXML
    private AnchorPane signin;
String emailAuth,passwordAuth;



    @Override
    public void initialize(URL location, ResourceBundle resources) {





    }



    public void loginAuth() {
        String email = getEmail.getText();
        String pass = getPassword.getText();

            try {


                auth = loader.load(Objects.requireNonNull(getClass().getResource("LeftBar.fxml")));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            login.getChildren().setAll(auth);


    }

    Stage stage;
    public void logupAuth() {



        stage=new Stage();


        stage.setTitle("SignUp Form");


        Parent login = null;
        try {
            login = loader.load(Objects.requireNonNull(getClass().getResource("LogUp.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        AnchorPane pane1=new AnchorPane();

        pane1.getChildren().add(login);
        Scene scene1=new Scene(pane1);

        stage.setScene(scene1);

        stage.show();

    }




    public void registered(ActionEvent e){

        String email = setEmail.getText();
        String pass = setPassword.getText();


            db=new DataBase();
            db.setAdmin(setFirstName.getText(),setLastName.getText(),phone.getText(),setEmail.getText(),setPassword.getText());


            final Node source = (Node) e.getSource();
            final Stage stage = (Stage) source.getScene().getWindow();
            stage.close();




    }



}
