package org.example;

import javafx.scene.paint.Color;

public class Plant {

    String name;
    int number;
    String type;
    String location;
    double x; double y; double r; Color color;
    String notes;

    public Plant(String name, int number, String type, String location, double x, double y, double r, Color color) {
        this.name = name;
        this.number = number;
        this.type = type;
        this.location = location;
        this.x = x;
        this.y = y;
        this.r = r;
        this.color = color;
    }

}

