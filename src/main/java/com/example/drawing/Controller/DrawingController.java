package com.example.drawing.Controller;

import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.*;

public class DrawingController<RenderedImage> {

    public ColorPicker colorPicker;
    public Button undo;
    public Button save;
    public Canvas canvas;
    public TextField shapeSize;
    public BorderPane borderPane;
    public Button zoomIn;
    public Button zoomOut;
    public CheckBox checkBox;
    public Button lineButton;
    public Button rectButton;

    public boolean isLineClicked = false;
    public boolean isZoomInClicked = false;
    public boolean isZoomOutClicked = false;


    public boolean isRectClicked = false;
    public ColorPicker secondColorPicker;

    Line line = new Line();
    Rectangle rectangle = new Rectangle();
    Stack<Rectangle> undoShapeRectangle = new Stack<Rectangle>();
    Stack<Line> undoShapeLine = new Stack<Line>();


    String color;

    GraphicsContext context;

    public void undoBtn(MouseEvent mouseEvent) {

        if (!undoShapeLine.isEmpty()) {
            undoShapeLine.pop();
            context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            for (int i = 0; i < undoShapeLine.size(); i++) {
                Shape shape = undoShapeLine.elementAt(i);
                if (shape.getClass() == Line.class) {
                    Line temp = (Line) shape;
                    context.setLineWidth(temp.getStrokeWidth());
                    context.setStroke(temp.getStroke());
                    context.setFill(temp.getFill());
                    context.strokeLine(temp.getStartX(), temp.getStartY(), temp.getEndX(), temp.getEndY());
                }
            }
        }
    }


        public void initialize () {
            context = canvas.getGraphicsContext2D();
            colorPicker.setValue(Color.BLACK);
            secondColorPicker.setValue(Color.TRANSPARENT);


            shapeSize.setText("12");
        }


        public void deleteAll (ActionEvent actionEvent){
            if (checkBox.isSelected()) {
                context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            }
        }


        public void zoomOut (MouseEvent mouseEvent){
        }

        public void zoomIn (MouseEvent mouseEvent){
            if (isZoomInClicked) {
                canvas.setOnMousePressed(e -> {
                    canvas.getOnZoom();
                    canvas.setScaleX(2);
                });
            }
        }

        public void lineAction (ActionEvent actionEvent){
            if (isLineClicked) {

                double size = Double.parseDouble(shapeSize.getText());
                canvas.setOnMousePressed(e -> {

                    System.out.println("canvas is pressed for Line");
                    context.setStroke(colorPicker.getValue());
                    context.setLineWidth(size);
                    line.setStartX(e.getX());
                    line.setStartY(e.getY());

                });

                canvas.setOnMouseDragged(e -> {
                    System.out.println("Line is dragged");
                });

                canvas.setOnMouseReleased(e -> {
                    System.out.println("Line is release");
                    line.setEndX(e.getX());
                    line.setEndY(e.getY());
                    context.strokeLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
                    undoShapeLine.push(new Line(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY()));
                });

            }

        }

        public void rectangleAction (ActionEvent actionEvent){
            if (isRectClicked) {
                canvas.setOnMousePressed(e -> {
                    double size = Double.parseDouble(shapeSize.getText());
                    context.setStroke(colorPicker.getValue());
                    context.setFill(secondColorPicker.getValue());
                    context.setLineWidth(size);
                    rectangle.setX(e.getX());
                    rectangle.setY(e.getY());
                });
                canvas.setOnMouseDragged(e -> {
                });
                canvas.setOnMouseReleased(e -> {
                    rectangle.setWidth(Math.abs((e.getX() - rectangle.getX())));
                    rectangle.setHeight(Math.abs((e.getY() - rectangle.getY())));
                    if (rectangle.getX() > e.getX()) {
                        rectangle.setX(e.getX());
                    }
                    if (rectangle.getY() > e.getY()) {
                        rectangle.setY(e.getY());
                    }
                    context.fillRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
                    context.strokeRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());

                    undoShapeRectangle.push(new Rectangle(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight()));


                });
            }

        }

        public void saveAction (ActionEvent actionEvent){

        }


        public void lineClicked (MouseEvent mouseEvent){
            isLineClicked = true;
            isRectClicked = false;
        }

        public void rectClicked (MouseEvent mouseEvent){
            isLineClicked = false;
            isRectClicked = true;
        }

        public void zoomInAction (ActionEvent actionEvent){
            isZoomInClicked = true;
            isZoomOutClicked = false;
        }

        public void zoomOutAction (ActionEvent actionEvent){
            isZoomInClicked = false;
            isZoomOutClicked = true;
        }

        public void saveClick (MouseEvent mouseEvent){
        }


        //Variabel med current shapetype typ. if sats.., tex enum. för att sen köra onAction på knappen.
    }







