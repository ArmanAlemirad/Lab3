package com.example.drawing.Models;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public abstract class Shape {
    private double startX;
    private double startY;
    private double size;
    private Color color;

    public Shape(double startX, double startY, double size, Color color) {
        this.startX = startX;
        this.startY = startY;
        this.size = size;
        this.color = color;
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

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public static Shape createShapes(ShapeType type, double startX, double startY, double size, Color color) {
        return switch (type) {
            case LINE -> new Line(startX, startY,0,0, size, color);
            case RECTANGLE -> new Rectangle(startX, startY, size, color, 0, 0);
        };
    }
    public abstract void draw(Canvas canvas);
    public abstract boolean checkInsideTheShape(double startX, double startY);
    public abstract String toSvg();
}