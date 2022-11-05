package com.example.drawing.Model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape{

    private double width;
    private double height;
    private double color;

    public Rectangle(double startX, double startY, double endX, double endY, double size, Color fillColor, double width, double height, double color) {
        super(startX, startY, endX, endY, size, fillColor);
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getColor() {
        return color;
    }

    public void setColor(double color) {
        this.color = color;
    }

    @Override
    public void draw(Canvas canvas) {
     /*   GraphicsContext context = canvas.getGraphicsContext2D();
        context.setStroke(getStrokeColor());
        context.strokeRect(getStartX(), getStartY(), getEndX(), getEndY());
        context.setFill(getFillColor());
        context.fillRect(getStartX(), getStartY() ,getStartY(), getEndX(), getEndY());

*/
    }
}
