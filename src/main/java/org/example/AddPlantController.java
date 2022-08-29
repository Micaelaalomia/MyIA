package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

import java.io.FileWriter;
import java.io.IOException;

public class AddPlantController{

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


        plantsName.setCellValueFactory(new PropertyValueFactory<>("name")); //gets plants names from Plant class

        plantsTable.getColumns().add(plantsName); //adds first column into table
        plantsTable.setItems(App.plants);

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


    //when save button is clicked, a new plant will be added to ObservableList.
    public void saveBtn(ActionEvent actionEvent) {
        boolean isValid = false;
        while (isValid == false) {
            if (pNameTxt.getText().equals("") || pTypeTxt.getText().equals("") || pLocationTxt.getText().equals("")) {
                // create a alert
                Alert a = new Alert(Alert.AlertType.NONE);
                // action event
                // set alert type
                a.setAlertType(Alert.AlertType.CONFIRMATION);
                a.setContentText("Blank spaces are not allowed. Try again.");
                // show the dialog
                a.show();
                break;
            } else {
                isValid = true;
            }
        }

        if (isValid == true){
            if (App.plants.size() <= max_NumberOfPlants) { //Only 5 plants can be added
                // Color.GREEN = 0x008000ff
                //System.out.println(Color.PINK);0xffc0cbff
                //System.out.println(Color.LAVENDER);0xe6e6faff
                //System.out.println(Color.MISTYROSE);0xffe4e1ff
                //System.out.println(Color.LIGHTYELLOW);0xffffe0ff
                //System.out.println(Color.SKYBLUE);0x87ceebff
                String color = "0x008000ff";
                int newPlantIndex = App.plants.size() - 1;
                switch (newPlantIndex) {
                    case 0:
                        color = "0x87ceebff";
                        break;
                    case 1:
                        color = "0xffc0cbff";
                        break;
                    case 2:
                        color = "0xe6e6faff";
                        break;
                    case 3:
                        color = "0xffe4e1ff";
                        break;
                    case 4:
                        color = "0xffffe0ff";
                        break;
                    case 5:
                        color = "0x87ceebff";
                        break;
                }
                //adds new plant
                App.plants.add(new Plant(pNameTxt.getText(), pTypeTxt.getText(), pLocationTxt.getText(), 10, 10, color));

            } else {
                // create a alert
                Alert a = new Alert(Alert.AlertType.NONE);
                // action event
                // set alert type
                a.setAlertType(Alert.AlertType.CONFIRMATION);
                a.setContentText("Ups...You’ve reached a maximum of 6 plants.");

                // show the dialog
                a.show();
            }
            // https://stackoverflow.com/questions/7080205/popup-message-boxes

            Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
            try (FileWriter writer = new FileWriter("plants.json")) {
                gson.toJson(App.plants, writer);
                System.out.println("Saved.");
            } catch (IOException e) {
                e.printStackTrace();
            }
            // https://mkyong.com/java/how-do-convert-java-object-to-from-json-format-gson-api/

        }
    }
}




