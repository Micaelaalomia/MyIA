package org.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class DiaryScreenController {

    @FXML
    public void switchToMainScreen() throws IOException {
        App.setRoot("MainScreen");
    }

}