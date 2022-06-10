package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class AddPlantController extends App{

    public TableView plantsTable;
    public TableColumn<Plant, String> plantsName = new TableColumn<>("Name");
    public TextField pNameTxt;
    public TextField pTypeTxt;
    public TextField pLocationTxt;
    int max_NumberOfPlants = 5;


    public void switchToMainScreen() throws IOException {
        App.setRoot("MainScreen");
    }

    //where this controller starts working when it is first loaded.
    public void initialize(){

        saveBtn(new ActionEvent());
        loadPlants();
        plantsName.setCellValueFactory(new PropertyValueFactory<Plant, String>("name")); //gets plants names from Plant class

        plantsTable.getColumns().add(plantsName); //adds first column into table
        plantsTable.setItems(plants);

        plantsTable.setRowFactory(rowClick ->{ //when row is clicked, something happens
            TableRow<Plant> row = new TableRow<>(); // a temporary row were information is saved into
            row.setOnMouseClicked(event ->{
                if(!row.isEmpty() && event.getButton()== MouseButton.PRIMARY && event.getClickCount() == 2){
                    Plant clickedRow = row.getItem();
                    pNameTxt.setText(clickedRow.getName());
                    pTypeTxt.setText(clickedRow.getType());
                    pLocationTxt.setText(clickedRow.getLocation());
                }
            });
            return row;
        });
    }

    private void loadPlants() {
        //loads plants from saved file
        //open and read JSON for any previously saved data
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        try(Reader reader = new FileReader("plants.json")){
            //convert JSON file to Java object
            ArrayList<Plant> imports = gson.fromJson(reader, new TypeToken<ArrayList<Plant>>(){ //each item in JSON file will be considered to be a plant
            }.getType());
            plants = FXCollections.observableArrayList(imports); //temporary ArrayList

        }catch (IOException e){
            e.printStackTrace();
        }
        // https://mkyong.com/java/how-do-convert-java-object-to-from-json-format-gson-api/
    }

    //when save button is clicked, a new plant will be added to ObservableList.
    public void saveBtn(ActionEvent actionEvent) {
        if (plants.size() <= max_NumberOfPlants) { //Only 5 plants can be added
            //adds new plant
            App.plants.add(new Plant(pNameTxt.getText(), pTypeTxt.getText(), pLocationTxt.getText(), 10, Color.GREEN));
        }
        // https://stackoverflow.com/questions/7080205/popup-message-boxes

        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        try(FileWriter writer = new FileWriter("plants.json")){
            gson.toJson(plants, writer);
            System.out.println("Saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // https://mkyong.com/java/how-do-convert-java-object-to-from-json-format-gson-api/
    }
}

