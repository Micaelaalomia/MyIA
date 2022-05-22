package org.example;

import java.io.IOException;

import javafx.event.ActionEvent;

public class ScheduleScreenController {

    public void switchToDiaryScreen(ActionEvent actionEvent) throws IOException {
        App.setRoot("DiaryScreen");
    }

    public void switchToMainScreen(ActionEvent actionEvent) throws IOException {
        App.setRoot("MainScreen");
    }
}
