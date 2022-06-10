package org.example;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class DiaryScreenController{

    Window stage;

    public void switchToMainScreen(ActionEvent actionEvent) throws IOException {
        App.setRoot("MainScreen");
    }

    public void switchToScheduleScreen(ActionEvent actionEvent) {
    }

    public void switchToDiaryScreen(ActionEvent actionEvent) {
    }

    private Desktop desktop = Desktop.getDesktop();
    public void selectImageBtn(ActionEvent actionEvent) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.showOpenDialog(stage);

        final Button openButton = new Button("Open a Picture...");
        openButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        configureFileChooser(fileChooser);
                        File file = fileChooser.showOpenDialog(stage);
                        if (file != null) {
                            openFile(file);
                        }
                    }
                });
    }

    private void configureFileChooser(FileChooser fileChooser) {
        fileChooser.setTitle("View Images");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
    }

     private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                    FileChooserSample.class.getName()).log(
                    Level.SEVERE, null, ex
            );
        }
    }

}