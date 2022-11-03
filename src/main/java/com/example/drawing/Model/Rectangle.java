
package com.example.drawing.Model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle(double startX, double startY, double endX, double endY, double size, Color fillColor, double width, double height) {
        super(startX, startY, endX, endY, size, fillColor);
        this.width = width;
        this.height = height;
    }

    @Override
    public void setFillColor(Color color) {

    }

    public void draw(Canvas canvas){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.strokeRect(getStartY(),getStartY(), width, height);
        gc.setFill(super.getFillColor());
        gc.fillRect(getStartX(), getStartY(), width, height);
    }

}
