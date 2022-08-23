package org.example;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
public class MainScreenController {

    @FXML
    public ImageView planImage;
    public AnchorPane mainPane;
    public Button addPlantBtn;

    public void switchToScheduleScreen() throws IOException {
       App.setRoot("ScheduleScreen");
    }

    public void switchToDiaryScreen() throws IOException {
        App.setRoot("DiaryScreen");
    }

    public void switchToMainScreen() throws IOException {
        App.setRoot("MainScreen");
    }

    public void switchToAddPlantScreen() throws IOException {
        App.setRoot("AddPlantScreen");
    }

    public void initialize(){
        for (Plant p: App.plants) {
          mainPane.getChildren().add(p); //gets each plant created and adds it to controller when app is ran
        }

        //when controller is initialized, it gets the planImage from a folder in the resources class.
        planImage.setImage(new Image(getClass().getResourceAsStream("/images/planImage.png")));
    }

    public void saveBtnAction(ActionEvent actionEvent) {
        for (Plant p: App.plants) {
            System.out.println(p.getTranslateX());
        }
        //force save plants incase locations have been changed
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        try(FileWriter writer = new FileWriter("plants.json")){
            gson.toJson(App.plants, writer);
            System.out.println("Saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


