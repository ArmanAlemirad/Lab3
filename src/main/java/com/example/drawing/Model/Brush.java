package com.example.drawing.Model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;

public class Brush extends Shape {
    public Brush(double x, double y) {
        super(x, y);
    }

    public void drawLine(Canvas canvas, ColorPicker colorPicker, TextField shapeSize) {
        GraphicsContext context = canvas.getGraphicsContext2D();
        canvas.setOnMouseDragged(e -> {
            double size = Double.parseDouble(shapeSize.getText());
            double x = e.getX() - size / 2;
            double y = e.getY() - size / 2;
            context.setFill(colorPicker.getValue());
            context.fillRect(x, y, size, size);
        });


    }
}
