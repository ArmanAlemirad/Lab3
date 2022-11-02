package com.example.drawing.Model;

public class Rectangle extends Shape {
    double height;
    double width;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Rectangle(double x, double y, double height) {
        super(x, y);
        this.height = height;
    }
}
