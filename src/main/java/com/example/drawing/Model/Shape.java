package com.example.drawing.Model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;

public abstract class Shape {

    private double startX;
    private double startY;
    private double endX;
    private double endY;
    private double size;
    private Color color;



    public Shape(double startX, double startY, double size, Color color) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
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

    public abstract void draw(Canvas canvas);
    public abstract boolean checkInsideTheShape(double startX, double startY);
    public abstract String toSvg();

    public static Shape createShapes(ShapeType type, double startX, double startY, double size, Color color) {
        return switch (type) {
            case LINE -> new Line(startX, startY,0,0, size, color);
            case RECTANGLE -> new Rectangle(startX, startY, size, color, 0, 0);
        };

    }


}