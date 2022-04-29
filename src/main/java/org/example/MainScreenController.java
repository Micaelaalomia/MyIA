package org.example;

import java.io.IOException;
import java.util.ArrayList;

// import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;

public class MainScreenController {

    @FXML
    public ImageView planImage;
    public AnchorPane mainPane;
    public Button addPlantBtn;

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
    ArrayList<Plant> plants = new ArrayList<>();

    public void initialize() throws IOException{
        planImage.setImage(new Image(getClass().getResourceAsStream("/images/planImage.png")));



        // circles8
        Circle redCircle = createCircle(addPlantBtn.getLayoutX()-50, addPlantBtn.getLayoutY()+(25), 10, Color.RED);
        // add the circles
        mainPane.getChildren().add(redCircle);


        // bring the circles to the front of the lines
        redCircle.toFront();


    }

    double orgSceneX, orgSceneY;

    private Circle createCircle(double x, double y, double r, Color color) {
        Circle circle = new Circle(x, y, r, color);

        circle.setCursor(Cursor.HAND);

        circle.setOnMousePressed((t) -> {
            orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();

            Circle c = (Circle) (t.getSource());
            c.toFront();
        });
        circle.setOnMouseDragged((t) -> {
            double offsetX = t.getSceneX() - orgSceneX;
            double offsetY = t.getSceneY() - orgSceneY;

            Circle c = (Circle) (t.getSource());

            c.setCenterX(c.getCenterX() + offsetX);
            c.setCenterY(c.getCenterY() + offsetY);

            orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();
        });
        return circle;
    }






}


