package org.example;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddPlantController {

    public TextField pNameTxt;
    public TextField pTypeTxt;
    public TextField pLocationTxt;

    public void switchToMainScreen() throws IOException {
        App.setRoot("MainScreen");
    }

    public void saveBtn(ActionEvent actionEvent) {
    }
}
