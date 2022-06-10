package org.example;

import com.google.gson.annotations.Expose;
import javafx.scene.Cursor;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class Plant extends StackPane {
    @Expose String name;
    @Expose int number;
    @Expose String type;
    @Expose String location;
    @Expose double x; @Expose double y; @Expose double r; @Expose Color color; //Variables for the constructor of a circle class.

    //The constructor below allows creating a plant.
    public Plant(String name, String type, String location, double r, Color color) {
        this.name = name;
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
    // http://www.java2s.com/Tutorials/Java/JavaFX_How_to/Shape/Handle_Shape_drag_and_drop_events.htm

    // Getter to get a variable of the plant from the primary controller.
    // Setter to update and change a variable of the plant.
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
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

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }
    public void setR(double r) {
        this.r = r;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}

