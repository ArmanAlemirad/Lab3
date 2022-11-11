package com.example.drawing.Models;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {


    private double width;
    private double height;

    public Rectangle(double startX, double startY, double size, Color color, double width, double height) {
        super(startX, startY, size, color);
        this.width = width;
        this.height = height;
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

    @Override
    public void draw(Canvas canvas) {
        GraphicsContext context = canvas.getGraphicsContext2D();
        context.setFill(getColor());
        context.fillRect(getStartX(), getStartY(), getWidth(), getHeight());
        context.strokeRect(getStartX(), getStartY(), getWidth(), getHeight());
    }


    @Override
    public boolean checkInsideTheShape(double mouseX, double mouseY) {

        double distanceToX = Math.abs(mouseX - getStartX());
        double distanceToY = Math.abs(mouseY - getStartY());

        return distanceToX <= (((getStartX() * 2) + getWidth()) / 2) && distanceToY <= (((getStartY() * 2) + getHeight()) / 2);
    }

    @Override
    public String toSvg() {
        return "<rect x=\"" + getStartX() + "\" y=\"" + getStartY() + "\" width=\"" + getWidth() + "\" height=\"" + getHeight() + "\" fill=\"" + getColor() + "\"/>";
    }
}