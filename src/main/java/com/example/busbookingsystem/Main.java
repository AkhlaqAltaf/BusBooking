package com.example.busbookingsystem;

import DB.DataBase;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.controlsfx.control.GridCell;
import org.controlsfx.control.GridView;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {


    FXMLLoader loader1;
DataBase db;

@Override
public void init() throws Exception{

}
    @Override


    public void start(Stage stage) throws IOException {

    db=new DataBase();
     db.getCustomer();

        Stage stage1=new Stage();
        stage1.setTitle("Login");
        Parent login = loader1.load(Objects.requireNonNull(getClass().getResource("Login.fxml")));

        AnchorPane pane1=new AnchorPane();
        pane1.getChildren().add(login);
        Scene scene1=new Scene(pane1);
        stage1.setScene(scene1);
        stage1.initModality(Modality.WINDOW_MODAL);
        scene1.getStylesheets().add(getClass().getResource("Admin.css").toExternalForm());
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("Icon.png")));
        stage1.show();


        stage.setTitle("Hello!");




    }

    public static void main(String[] args) {
//Practice obj=new Practice();
//obj.getActionOn();
launch(args);
    }
}