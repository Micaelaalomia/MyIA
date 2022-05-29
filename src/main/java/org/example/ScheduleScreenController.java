package org.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class ScheduleScreenController {

    private Window stage;

    public void switchToDiaryScreen(ActionEvent actionEvent) throws IOException {
        App.setRoot("DiaryScreen");
    }

    public void switchToMainScreen(ActionEvent actionEvent) throws IOException {
        App.setRoot("MainScreen");
    }

    //when save button is clicked, a new plant will be added to arrayList.
    public void selectBtn(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.showOpenDialog(stage);
    }
}
