package org.example;

public class PlantTemp {
    String name;
    String type;
    String location;
    double pX;
    double pY;
    String color;

    public PlantTemp(String name, String type, String location, double pX, double pY, String color) {
        this.name = name;
        this.type = type;
        this.location = location;
        this.pX = pX;
        this.pY = pY;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

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
