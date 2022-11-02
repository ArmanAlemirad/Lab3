package com.example.drawing.Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.shape.Circle;

public class Shape {

    private final double x;
    private final double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

}