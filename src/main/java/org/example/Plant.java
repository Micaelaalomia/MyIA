package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.io.FileWriter;
import java.io.IOException;

public class Plant extends StackPane {
    @Expose String name;
    @Expose String type;
    @Expose String location;
    @Expose double pX; @Expose double pY; //Variables for the constructor of a circle class.
    @Expose String color;
    //com.google.gson.annotations

    //The constructor below allows creating a plant.
    public Plant(String name, String type, String location, double pX, double pY, String color) {
        this.name = name;
        this.type = type;
        this.location = location;
        this.color = color;
        int r = 10;
        this.pX = pX;
        this.pY = pY;
        Circle circle = new Circle(r, Color.valueOf(color)); //Creates a circle for the last plant added
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(1);
        Text text = new Text(":)"); //Plant starts off happy

        Label plantInfoLabel = new Label(this.getName() + "\n " + this.getType()+ "\n " + this.getLocation());
        plantInfoLabel.setStyle("-fx-background-color: #f4f4f4;-fx-border-color: #000000;");

        plantInfoLabel.setTranslateX(25);
        plantInfoLabel.setVisible(false);

        this.setCursor(Cursor.HAND);
        setOnMousePressed((t) -> {
            Plant c = (Plant) (t.getSource()); //Finds out which plant it was
            text.setText(":0"); //When mouse pressed, plant looks shocked
            plantInfoLabel.setVisible(true);
            c.toFront(); //Brings the plant to the front
        });
        setOnMouseDragged((t) -> {
            Plant c = (Plant) (t.getSource()); //Finds out which plant it was
            c.setTranslateX(t.getX() + c.getTranslateX() - r);
            c.setTranslateY(t.getY() + c.getTranslateY() - r);
            t.consume();
        });
        setOnMouseReleased((t) -> {
            plantInfoLabel.setVisible(false);
            Plant c = (Plant) (t.getSource()); //Finds out which plant it was
            c.pX = c.getTranslateX(); //This is to save the x-coordinate for its new location.
            c.pY = c.getTranslateY(); //This is to save the y-coordinate for its new location.
            text.setText(":)"); //When mouse released, plant looks happy again
        });

        this.getChildren().addAll(circle, text, plantInfoLabel);
        this.setTranslateX(pX);
        this.setTranslateY(pY);
    }
    // http://www.java2s.com/Tutorials/Java/JavaFX_How_to/Shape/Handle_Shape_drag_and_drop_events.htm

    // Getter to get a variable of the plant from the primary controller.
    // Setter to update and change a variable of the plant.
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public double getpX() {
        return pX;
    }

    public void setpX(double pX) {
        this.pX = pX;
    }

    public double getpY() {
        return pY;
    }

    public void setpY(double pY) {
        this.pY = pY;
    }
}

