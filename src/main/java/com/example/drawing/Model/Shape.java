package com.example.drawing.Model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {

    private double startX;
    private double startY;
    private double endX;
    private double endY;
    private double size;

    private Color strokeColor;

    public Shape(double startX, double startY, double endX, double endY, double size, Color strokeColor) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.size = size;
        this.strokeColor = strokeColor;
    }


    public double getStartX() {
        return startX;
    }

    public void setStartX(double startX) {
        this.startX = startX;
    }

    public double getStartY() {
        return startY;
    }

    public void setStartY(double startY) {
        this.startY = startY;
    }

    public double getEndX() {
        return endX;
    }

    public void setEndX(double endX) {
        this.endX = endX;
    }

    public double getEndY() {
        return endY;
    }

    public void setEndY(double endY) {
        this.endY = endY;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Color getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }

    public abstract void draw(Canvas canvas);

    public static Shape createShape(ShapeType type, double startX, double startY, double endX, double endY, double size, Color strokeColor) {
        return switch (type) {
            case LINE -> new Line(startX, startY, endX, endY, size, strokeColor);
            case RECTANGLE -> new Rectangle(startX, startY, endX, endY, size, strokeColor, 0, 0, strokeColor);
        };

    }
}