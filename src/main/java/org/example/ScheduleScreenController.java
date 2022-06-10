package org.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class ScheduleScreenController extends MainScreenController{

    public void switchToDiaryScreen(ActionEvent actionEvent) throws IOException {
        App.setRoot("DiaryScreen");
    }

    public void switchToMainScreen(ActionEvent actionEvent) throws IOException {
        App.setRoot("MainScreen");
    }
}
