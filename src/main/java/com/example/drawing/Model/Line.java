package com.example.drawing.Model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class Line extends Shape {

    private double width;

    private List<Double> shapeCordinateX ;
    private List<Double> shapeCordinateY ;



    public Line(double startX, double startY, double endX, double endY, double size, Color fillColor, double width) {
        super(startX, startY, endX, endY, size, fillColor);
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public List<Double> getShapeCordinateX() {
        return shapeCordinateX;
    }

    public void setShapeCordinateX(List<Double> shapeCordinateX) {
        this.shapeCordinateX = shapeCordinateX;
    }

    public List<Double> getShapeCordinateY() {
        return shapeCordinateY;
    }

    public void setShapeCordinateY(List<Double> shapeCordinateY) {
        this.shapeCordinateY = shapeCordinateY;
    }

    @Override
    public void draw(Canvas canvas) {

            GraphicsContext context = canvas.getGraphicsContext2D();
            context.setLineWidth(getSize());
            context.setStroke(getFillColor());
            context.strokeLine(getStartX(), getStartY(getEndY()), getEndX(), getEndY());

    }
}