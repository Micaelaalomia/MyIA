package org.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainScreenController {




    public void switchToScheduleScreen(ActionEvent actionEvent) throws IOException {
       App.setRoot("ScheduleScreen");
    }

    public void switchToDiaryScreen(ActionEvent actionEvent) throws IOException {
        App.setRoot("DiaryScreen");
    }

    public void switchToUploadPhotoScreen(ActionEvent actionEvent) throws IOException {
        App.setRoot("UploadScreen");
    }

    public void switchToMainScreen(ActionEvent actionEvent) throws IOException {
        App.setRoot("MainScreen");
    }
}
