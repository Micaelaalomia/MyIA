package org.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class DiaryScreenController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    public void initialize(){
        new Plant("Purple Orchidea", 1, "Orchidea", "Inside");
    }
}