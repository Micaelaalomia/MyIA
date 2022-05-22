package org.example;

import javafx.scene.Cursor;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class Plant extends StackPane {
    String name;
    int number;
    String type;
    String location;
    double x; double y; double r; Color color; //Variables for the constructor of a circle class.
    String notes;
    double orgSceneX, orgSceneY;

    public Plant(String name, int number, String type, String location, double r, Color color) {
        this.name = name;
        this.number = number;
        this.type = type;
        this.location = location;

        final Circle circle = new Circle(r, color); //Creates a circle for the last plant added
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(1);
        final Text text = new Text(":)"); //Plant starts off happy

        this.setCursor(Cursor.HAND);

        this.setOnMousePressed((t) -> {
            Plant c = (Plant) (t.getSource()); //Finds out which plant it was
            text.setText(":0"); //When mouse pressed, plant looks shocked
            c.toFront(); //Brings the plant to the front
        });
        this.setOnMouseDragged(event -> { // When dragged, plant moves around
            this.setTranslateX(event.getX() + this.getTranslateX() - r);
            this.setTranslateY(event.getY() + this.getTranslateY() - r);
            this.x = event.getX() + this.getTranslateX() - r; //This is to save the x-coordinate for its new location.
            this.y = event.getX() + this.getTranslateY() - r; //This is to save the y-coordinate for its new location.
            event.consume();
        });
        setOnMouseReleased(event -> {
            text.setText(":)"); //When mouse released, plant looks happy again
        });

        this.getChildren().addAll(circle, text);
    }
}

