package com.example.drawing.Model;

public class Circle extends Shape{
    double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }
}
