package org.example;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;

public class AddPlantController extends App{

    public TableView plantsTable;
    public TableColumn<Plant, String> plantsName = new TableColumn<>("Name");
    public TextField pNameTxt;
    public TextField pTypeTxt;
    public TextField pLocationTxt;
    int max_NumberOfPlants = plants.size();


    public void switchToMainScreen() throws IOException {
        App.setRoot("MainScreen");
    }

    public void initialize(){
        //where this controller starts working when it is first loaded.

        plantsTable.getColumns().add(plantsName); //adds first column into table
        plantsTable.setItems(plants);
    }

    //when save button is clicked, a new plant will be added to arrayList.
    public void saveBtn() {
        while (max_NumberOfPlants < 6) {
            App.plants.add(new Plant(pNameTxt.getText(), pTypeTxt.getText(), pLocationTxt.getText(), 10, Color.GREEN)); //adds new plant
        }
    }
}
