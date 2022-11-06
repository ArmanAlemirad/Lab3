package com.example.drawing.Model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class Line extends Shape {
    public Line(double startX, double startY, double endX, double endY, double size, Color fillColor) {
        super(startX, startY, endX, endY, size, fillColor);
    }

    @Override
    public void draw(Canvas canvas) {

            GraphicsContext context = canvas.getGraphicsContext2D();
            context.setLineWidth(getSize());
            context.setStroke(getStrokeColor());
            context.strokeLine(getStartX(),getStartY(), getEndX(), getEndY());

    }
}