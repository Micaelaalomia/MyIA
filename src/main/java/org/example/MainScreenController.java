package org.example;

import java.io.IOException;

import javafx.event.ActionEvent;
// import javafx.fxml.FXML;
// import javafx.scene.control.Button;

public class MainScreenController {

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
}
