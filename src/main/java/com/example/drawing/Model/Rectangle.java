package com.example.drawing.Model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;

public class Rectangle extends Shape {
    double height;
    double width;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Rectangle(double x, double y, double height, double width) {
        super(x, y);
        this.height = height;
        this.width = width;

    }
    public void draw (Canvas canvas) {
        GraphicsContext context = canvas.getGraphicsContext2D();
        context.setFill(getColor());
        context.fillRect(getX(),getY(),20,20);

    }

   /* public void draw (Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(super.getColor());
        gc.strokeRect(super.getTopLeft().getX(), super.getTopLeft().getY(), width, height);
        gc.setFill(super.getFillColor());
        gc.fillRect(super.getTopLeft().getX(), super.getTopLeft().getY(), width, height);

    }*/
}