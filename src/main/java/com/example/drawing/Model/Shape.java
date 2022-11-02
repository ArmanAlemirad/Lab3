package com.example.drawing.Model;

import javafx.scene.paint.Color;

import static com.example.drawing.Model.ShapeType.*;

public class Shape {

    private final double x;
    private final double y;
    private Color color;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
        color = Color.BLACK;


    }

    public static Shape createShape(ShapeType type, double x, double y) {
        return switch (type) {
            case CIRCLE -> new Circle(x, y, 0);
            case RECTANGLE -> new Rectangle(x, y, 0, 0);
            case LINE -> new Line(x, y);
        };


    }
}