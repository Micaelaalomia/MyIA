package org.example;

import java.io.IOException;

// import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainScreenController {

    public ImageView planImage;
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
        Image image = Image("\planImage.png");
        planImage.setImage(image);
    }
}
