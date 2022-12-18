package com.example.busbookingsystem;

import DB.DataBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;




public class Controler implements Initializable {
    DataBase db = new DataBase();

    @FXML
    private ListView customerList;

    @FXML
    private ComboBox busID;

    @FXML
    private AnchorPane customerPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }


    @FXML
    private TextField cName, clName, cPhone, cEmail;
    @FXML
    private ComboBox cGender;
    @FXML
    private DatePicker cDate;
    @FXML
    private Label error;

    @FXML
    private AnchorPane rightSide;
    @FXML
    private AnchorPane busInfo;
    AnchorPane setRight = null;
    FXMLLoader loader;

    public void dashboard() {

        try {
            setRight = loader.load(Objects.requireNonNull(getClass().getResource("Dashboard.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        rightSide.getChildren().setAll(setRight);
        System.out.println("Complete");

    }

    public void availableBuses() {

        try {
            setRight = loader.load(Objects.requireNonNull(getClass().getResource("AvailableBuses.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        rightSide.getChildren().setAll(setRight);
    }

    public void bookingTicket() {

        try {
            setRight = loader.load(Objects.requireNonNull(getClass().getResource("BookingBusDetail.fxml")));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        rightSide.getChildren().setAll(setRight);


    }

    Stage customerInfo = null;

    public void getCustomer() {

        customerInfo = new Stage();
        FXMLLoader loade = null;
        Parent leftBar = null;
        customerInfo.setTitle("Book A Seat For Customer");
        try {
            leftBar = loade.load(Objects.requireNonNull(getClass().getResource("CustomerInfo.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(leftBar);
        customerInfo.setScene(scene);
        customerInfo.show();


    }

    public void book(ActionEvent e) {

        db = new DataBase();


        if (cName.getText().isEmpty() || cGender.getItems().isEmpty() || clName.getText().isEmpty()) {

            error.setText("Please Fill All These Blanks");
        } else {

            db.setCustomer(cName.getText(), cPhone.getText(), "87532");


            final Node source = (Node) e.getSource();
            final Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
        }
    }


    public void signout(ActionEvent e) {


        final Node source = (Node) e.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
        FXMLLoader loader1 = new FXMLLoader();

        Stage newStage1 = new Stage();
        Parent root = null;
        try {
            root = loader1.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public void customers() {
        Stage st = new Stage();


        ListView customerList = new ListView<>();
        customerList.setItems(FXCollections.observableArrayList(db.getCustomer()));
        customerList.prefWidth(800);

        customerList.prefWidth(800);


        st.setTitle("All Customer Till Now");

        Scene scene = new Scene(customerList, 400, 400);


        scene.setFill(new LinearGradient(
                0, 0, 1, 1, true,                      //sizing
                CycleMethod.NO_CYCLE,                  //cycling
                new Stop(0, Color.web("#81c483")),     //colors
                new Stop(1, Color.web("#fcc200")))
        );

        st.setScene(scene);

        st.show();


    }

}