package org.example;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

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

    public void initialize() throws IOException{

        for (Plant p: App.plants) {
            mainPane.getChildren().add(p); //gets each plant created and adds it to controller when app is ran
        }

        //when controller is initialized, it gets the planImage from a folder in the resources class.
        planImage.setImage(new Image(getClass().getResourceAsStream("/images/planImage.png")));
    }
}


