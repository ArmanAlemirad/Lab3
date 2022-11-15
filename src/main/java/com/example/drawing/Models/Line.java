package com.example.drawing.Models;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line extends Shape {
    private double endX;
    private double endY;
    public Line(double startX, double startY, double endX, double endY, double size, Color color) {
        super(startX, startY, size, color);
        this.endX = endX;
        this.endY = endY;
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
    public void draw(Canvas canvas) {
            GraphicsContext context = canvas.getGraphicsContext2D();
            context.save();
            context.setLineWidth(getSize());
            context.setStroke(getColor());
            context.strokeLine(getStartX(),getStartY(),getEndX(), getEndY());
            context.restore();
    }

    @Override
    public boolean checkInsideTheShape (double mouseX, double mouseY){
        return getStartX() < mouseX && mouseX < getEndX() && getStartY()<mouseY && mouseY< getEndY();
    }

@Override
    public String toSvg() {
        return "<line x1=\"" + getStartX() + "\" x2=\""+ getEndX() + "\" y1=\"" + getStartY() + "\" y2=\""+getEndY() + "\" stroke-width=\"" + getSize() + "\" stroke=\"#" + getColor().toString().substring(4) + "\"/>";
    }
}
