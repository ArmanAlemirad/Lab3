package com.example.drawing.Model;

import javafx.scene.canvas.Canvas;

public abstract class Shape {

    private  double startX;
    private  double startY;
    private double endX;
    private double endY;

    private double size;

    private String color;

    public Shape(double startX, double startY, double endX, double endY, double size) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.size = size;
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

    public abstract void draw (Canvas canvas);
}