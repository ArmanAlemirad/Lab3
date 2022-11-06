package com.example.drawing.Model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape{

    private double width;
    private double height;
    private Color fillColor;

    public Rectangle(double startX, double startY, double endX, double endY, double size, Color strokeColor, double width, double height, Color fillColor) {
        super(startX, startY, endX, endY, size, strokeColor);
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
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

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    @Override
    public void draw(Canvas canvas) {
      GraphicsContext context = canvas.getGraphicsContext2D();
        context.setStroke(getStrokeColor());
        context.setFill(getFillColor());
        context.setLineWidth(getSize());
        context.fillRect(getStartX(), getStartY(), getWidth(), getHeight());
        context.strokeRect(getStartX(), getStartY(),getWidth(), getHeight());
    }
}
