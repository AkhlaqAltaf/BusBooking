package com.example.busbookingsystem;
import DB.DataBase;
import com.dlsc.formsfx.model.structure.IntegerField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AvailableBuses implements Initializable {


    @FXML
    private TextField busID,root;
   @FXML
   private ListView listView;
    @FXML
    private TextField pric;
    @FXML
   private DatePicker date;





DataBase db=new DataBase();
    @Override
    public void initialize(URL location, ResourceBundle resources) {



        ObservableList<String> wordsList = FXCollections.observableArrayList("First word","Second word", "Third word", "Etc.");
        ListView<String> listViewOfStrings = new ListView<>(wordsList);



        ListView list=new ListView<>();
        list.cellFactoryProperty();
        Scene li=new Scene(listViewOfStrings);
        listView.setItems(FXCollections.observableArrayList(db.getBuse()));






    }


    public void update(ActionEvent event) {
    }


    public void add(ActionEvent event) {

        String date = this.date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        db.addBuses(busID.getText(),root.getText(),pric.getText(),date);


    }

    public void reset(ActionEvent event) {
    }

    public void delete(ActionEvent event) {
    }


}
