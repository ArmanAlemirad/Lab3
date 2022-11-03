package com.example.drawing.Model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line extends Shape {
    public Line(double startX, double startY, double endX, double endY, double size, Color color) {
        super(startX, startY, endX, endY, size, color);
    }

    public void draw (Canvas canvas) {
        GraphicsContext context = canvas.getGraphicsContext2D();
        context.setFill(getColor());
        context.setLineWidth(getSize());
        context.strokeLine(getStartY(),getStartY(),getEndX(),getEndY());


    }
}
