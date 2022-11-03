package com.example.drawing.Model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;

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

    public void draw (Canvas canvas) {
        GraphicsContext context = canvas.getGraphicsContext2D();
        context.setFill(getColor());
        context.fillRect(getX(),getY(),20,20);

    }
}
