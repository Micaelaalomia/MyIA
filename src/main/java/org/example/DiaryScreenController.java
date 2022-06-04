package org.example;

import java.io.IOException;

import javafx.event.ActionEvent;

public class DiaryScreenController extends MainScreenController{

    public void switchToMainScreen(ActionEvent actionEvent) throws IOException {
        App.setRoot("MainScreen");
    }

    public void switchToScheduleScreen(ActionEvent actionEvent) {
    }

    public void switchToDiaryScreen(ActionEvent actionEvent) {
    }
}