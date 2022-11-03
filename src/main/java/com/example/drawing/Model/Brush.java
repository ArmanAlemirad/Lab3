package com.example.drawing.Model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;

public class Brush extends Shape {
    public Brush(double x, double y) {
        super(x, y);
    }

    public void draw (Canvas canvas) {
        GraphicsContext context = canvas.getGraphicsContext2D();
        context.setFill(getColor());
        context.fillRect(getX(),getY(),20,20);

    }
}
